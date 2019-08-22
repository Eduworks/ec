package assimilater;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * XSD to Java:
 * 1) Remove all non version 1 tags from XSD (ex: xsd:assert).  JAXB only supports XSD v1.
 * 2) Convert XSD to Java Classes via JAXB with command line:
 *          ex: xjc -npa -no-header -d C:\TomsWorkFast\intellijWorkspace\JAXBToSTJS\src -p sourceFiles C:\TomsWorkFast\intellijWorkspace\JAXBToSTJS\src\xsd\s6000t_0-1_task_train_analysis.xsd
 * 3) Modify the SOURCE_FOLDER, DEST_FOLDER, SOURCE_PACKAGE, DEST_PACKAGE, and EC_REMOTE_LD_CONSTR_SCHEMA constants in
 *      this class to the appropriate values (Don't forget trailing file separators!!!)
 * 4) Run the main method of this class
 * 5) Do any needed refactoring (moving S6000t classes to the appropriate package...didn't have time to make this automatic)
 *
 * Known issues:
 *  -Enumeration nested in class file may cause issues (None of these exist in tested XSDs)
 *  -removeJaxbElement may need to be expanded to handle lines with multiple ">" characters
 *  -Had to replace BigInteger and BigDecimal with long and double (respectively).  No java.math libraries with STJS
 *
 */

public class JaxbToStjsAssimilater {

    private static final String SOURCE_FOLDER = "C:\\TomsWorkFast\\intellijWorkspace\\JAXBToSTJS\\src\\sourceFiles\\";
    //private static final String DEST_FOLDER = "C:\\TomsWorkFast\\intellijWorkspace\\ec\\asd.europe.org.s_series\\src\\main\\java\\s6000t\\taskTrainAnalysis\\";
    //private static final String DEST_FOLDER = "C:\\TomsWorkFast\\intellijWorkspace\\ec\\cass.rollup\\src\\main\\java\\cass\\rollup\\s6000t\\taskTrainAnalysis\\";
    private static final String DEST_FOLDER = "C:\\TomsWorkFast\\intellijWorkspace\\ec\\asd.europe.org.s_series\\src\\main\\java\\s3000l\\";

    private static final String SOURCE_PACKAGE = "sourceFiles";
    private static final String DEST_PACKAGE = "s3000l";
    //private static final String DEST_PACKAGE = "cass.rollup.s6000t.taskTrainAnalysis";

    private static final String EC_REMOTE_LD_CONSTR_SCHEMA = "http://www.asd-europe.org/s-series/s3000l";

    private static final boolean LOG_ENABLED = true;

    private static final boolean REMOVE_DOUBLE_BLANK_LINES = true;
    private static final boolean ADD_ASSIMILATER_HEADER = true;

    private static final String EC_REMOTE_LD_IMPORT = "org.cassproject.schema.general.EcRemoteLinkedData";
    private static final String STJS_DATE_IMPORT = "org.stjs.javascript.Date";
    private static final String STJS_ARRAY_IMPORT = "org.stjs.javascript.Array";

    private String sourceFolder;
    private String destFolder;
    private String sourcePackage;
    private String destPackage;

    private ArrayList<File> fileList = new ArrayList<>();
    private ArrayList<File> erroredFileList = new ArrayList<>();

    private String currentLine;
    private String lastBufferLine;
    private String currentFileName;
    private boolean currentFileEnum = false;
    private boolean endOfEnumsFound = false;
    private boolean initialClassDeclarationFound = false;
    private boolean currentFileMainTypeDefined = false;
    private boolean includeStjsArrayImport = false;
    private boolean includeStjsDateImport = false;
    private ArrayList<String> contentBuffer = new ArrayList<>();

    private BufferedReader reader;
    private PrintWriter writer;

    public boolean isInitialClassDeclarationFound() {
        return initialClassDeclarationFound;
    }

    public void setInitialClassDeclarationFound(boolean initialClassDeclarationFound) {
        this.initialClassDeclarationFound = initialClassDeclarationFound;
    }

    public String getCurrentFileName() {
        return currentFileName;
    }

    public void setCurrentFileName(String currentFileName) {
        this.currentFileName = currentFileName;
    }

    public boolean isEndOfEnumsFound() {
        return endOfEnumsFound;
    }

    public void setEndOfEnumsFound(boolean endOfEnumsFound) {
        this.endOfEnumsFound = endOfEnumsFound;
    }

    public String getSourcePackage() {
        return sourcePackage;
    }

    public void setSourcePackage(String sourcePackage) {
        this.sourcePackage = sourcePackage;
    }

    public String getLastBufferLine() {
        return lastBufferLine;
    }

    public void setLastBufferLine(String lastBufferLine) {
        this.lastBufferLine = lastBufferLine;
    }

    public boolean isCurrentFileMainTypeDefined() {
        return currentFileMainTypeDefined;
    }

    public void setCurrentFileMainTypeDefined(boolean currentFileMainTypeDefined) {
        this.currentFileMainTypeDefined = currentFileMainTypeDefined;
    }

    public String getCurrentLine() {
        return currentLine;
    }

    public void setCurrentLine(String currentLine) {
        this.currentLine = currentLine;
    }

    public boolean isCurrentFileEnum() {
        return currentFileEnum;
    }

    public void setCurrentFileEnum(boolean currentFileEnum) {
        this.currentFileEnum = currentFileEnum;
    }

    public String getDestPackage() {
        return destPackage;
    }

    public void setDestPackage(String destPackage) {
        this.destPackage = destPackage;
    }

    public boolean getIncludeStjsArrayImport() {
        return includeStjsArrayImport;
    }

    public void setIncludeStjsArrayImport(boolean includeStjsArrayImport) {
        this.includeStjsArrayImport = includeStjsArrayImport;
    }

    public boolean getIncludeStjsDateImport() {
        return includeStjsDateImport;
    }

    public void setIncludeStjsDateImport(boolean includeStjsDateImport) {
        this.includeStjsDateImport = includeStjsDateImport;
    }

    public ArrayList<String> getContentBuffer() {
        return contentBuffer;
    }

    public void setContentBuffer(ArrayList<String> contentBuffer) {
        this.contentBuffer = contentBuffer;
    }

    public String getSourceFolder() {
        return sourceFolder;
    }

    public void setSourceFolder(String sourceFolder) {
        this.sourceFolder = sourceFolder;
    }

    public String getDestFolder() {
        return destFolder;
    }

    public void setDestFolder(String destFolder) {
        this.destFolder = destFolder;
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }

    public ArrayList<File> getErroredFileList() {
        return erroredFileList;
    }

    public void setErroredFileList(ArrayList<File> erroredFileList) {
        this.erroredFileList = erroredFileList;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public ArrayList<File> getFileList() {
        return fileList;
    }

    public void setFileList(ArrayList<File> fileList) {
        this.fileList = fileList;
    }

    private void log(Object o) {
        if (LOG_ENABLED) {
            Calendar cal = Calendar.getInstance();
            System.out.println(cal.getTime().toString() + ": " + o.toString());
        }
    }

    private void addLineToContentBuffer(String line) {
        if (REMOVE_DOUBLE_BLANK_LINES && getLastBufferLine() != null && getLastBufferLine().equals("") && line.trim().equals("")) {
            //do nothing
        }
        else getContentBuffer().add(line);
        setLastBufferLine(line.trim());
    }

    private int numberOfInstances(String searchString, char targetChar) {
        char[] sca = searchString.toCharArray();
        int num = 0;
        for (char c:sca) if (c == targetChar) num++;
        return num;
    }

    private void skipCodeBlocks(String line,char openChar, char closeChar) throws Exception {
        int numOpens = numberOfInstances(line,openChar);
        int numCloses = numberOfInstances(line,closeChar);
        String nextLine;
        while (numCloses < numOpens) {
            nextLine = getReader().readLine();
            numOpens += numberOfInstances(nextLine,openChar);
            numCloses += numberOfInstances(nextLine,closeChar);
        }
    }

    private String removeJaxbElement(String line) throws Exception {
        //todo this may not be sufficient
        String newLine = line;
        newLine = newLine.replace("JAXBElement<" + getSourcePackage(),getDestPackage());
        newLine = newLine.replace("JAXBElement<","");
        newLine = newLine.replace(">","");
        return newLine;
    }

    private String replaceListOrArrayList(String line) throws Exception {
        String newLine = line;
        newLine = newLine.replace("ArrayList<","Array<");
        newLine = newLine.replace("List<","Array<");
        newLine = newLine.replace("Array<" + getSourcePackage(),"Array<" + getDestPackage());
        setIncludeStjsArrayImport(true);
        return newLine;
    }

    private String replaceXmlGregorianCalendar(String line) throws Exception {
        String newLine = line;
        newLine = newLine.replace("XMLGregorianCalendar","Date");
        setIncludeStjsDateImport(true);
        return newLine;
    }

    private String replaceBigDecimal(String line) throws Exception {
        String newLine = line;
        newLine = newLine.replace("BigDecimal","double");
        return newLine;
    }

    private String replaceBigInteger(String line) throws Exception {
        String newLine = line;
        newLine = newLine.replace("BigInteger","long");
        return newLine;
    }

    private void ignore() {
    }

    private String addExtendEcRemoteLinkedDataToClassDeclaration(String line) {
        String className = getCurrentFileName().replace(".java","");
        int endNameIdx = line.indexOf(className) + className.length();
        return line.substring(0,endNameIdx) + " extends EcRemoteLinkedData {";
    }

    private void scrubAndAddClassFileLine(String line) throws Exception {
        String lineCopy = line;
        while (true) {
            if (lineCopy.contains("protected String id")) {
                ignore();
                break;
            }
            else if (lineCopy.contains("public String getId()") || lineCopy.contains("public void setId(") ) {
                skipCodeBlocks(lineCopy,'{','}');
                break;
            }
            else if (lineCopy.contains("JAXBElement")) lineCopy = removeJaxbElement(lineCopy);
            else if (lineCopy.contains("List<")) lineCopy = replaceListOrArrayList(lineCopy);
            else if (lineCopy.contains("XMLGregorianCalendar")) lineCopy = replaceXmlGregorianCalendar(lineCopy);
            else if (lineCopy.contains("BigDecimal")) lineCopy = replaceBigDecimal(lineCopy);
            else if (lineCopy.contains("BigInteger")) lineCopy = replaceBigInteger(lineCopy);
            else {
                if (lineCopy.contains("public class") && !isInitialClassDeclarationFound()) {
                    setInitialClassDeclarationFound(true);
                    lineCopy = addExtendEcRemoteLinkedDataToClassDeclaration(lineCopy);
                }
                addLineToContentBuffer(lineCopy);
                break;
            }
        }
    }

    private String removeExtraEnumDefInfo(String line) {
        if (line.contains("(")) {
            int start = line.indexOf("(");
            int end = line.indexOf(")");
            return line.substring(0, start) + line.substring(end + 1);
        }
        else return line;
    }

    private void scrubAndAddEnumFileLine(String line) throws Exception {
        String lineTrimmed = line.trim();
        if (lineTrimmed.startsWith("public enum")) addLineToContentBuffer(line);
        else {
            if (!isEndOfEnumsFound()) {
                String newLine = removeExtraEnumDefInfo(line);
                addLineToContentBuffer(newLine);
                if (newLine.endsWith(";")) {
                    setEndOfEnumsFound(true);
                    addLineToContentBuffer("}");
                }
            }
            else ignore();
        }
    }

    private void determineFileMainType(String lineTrimmed) {
        if (!isCurrentFileMainTypeDefined()) {
            if (lineTrimmed.startsWith("public class")) setCurrentFileEnum(false);
            else setCurrentFileEnum(true);
            setCurrentFileMainTypeDefined(true);
        }
    }

    private int getEndClassBracketIndexFromContentBuffer() {
        int endClassBracketIndex = -1;
        for (int i=getContentBuffer().size() - 1;i>=0;i--) {
            if (getContentBuffer().get(i).trim().equals("}")) {
                endClassBracketIndex = i;
                break;
            }
        }
        return endClassBracketIndex;
    }

    private List<String> generateClassConstructor() {
        ArrayList<String> constructorLines = new ArrayList<>();
        String className = getCurrentFileName().replace(".java","");
        constructorLines.add("");
        constructorLines.add("\tpublic " + className + "() {");
        constructorLines.add("\t\tsuper(\"" + EC_REMOTE_LD_CONSTR_SCHEMA + "\", \"" + className + "\");");
        constructorLines.add("\t}");
        return constructorLines;
    }

    private void addClassConstructor() {
        if (!isCurrentFileEnum()) {
            int endClassBracketIndex = getEndClassBracketIndexFromContentBuffer();
            if (endClassBracketIndex > -1) {
                getContentBuffer().addAll(endClassBracketIndex - 1,generateClassConstructor());
            }
            else log("Could not determine endClassBracketIndex for '" + getCurrentFileName() + "'");
        }
    }

    private void scrubFileContents() throws Exception {
        //todo enums vs classes
        String line = getReader().readLine();
        while (line != null) {
            String lineTrimmed = line.trim();
            if (lineTrimmed.startsWith("package")) ignore();
            else if (lineTrimmed.startsWith("import")) ignore();
            else if (lineTrimmed.startsWith("/**")) ignore();
            else if (lineTrimmed.startsWith("*")) ignore();
            else if (lineTrimmed.startsWith("@XmlID")) ignore();
            else if (lineTrimmed.startsWith("@XmlEnum")) ignore();
            else if (lineTrimmed.startsWith("@Xml") && lineTrimmed.contains("(")) skipCodeBlocks(line,'(',')');
            else {
                if (!isCurrentFileMainTypeDefined() && lineTrimmed.startsWith("public class") || lineTrimmed.startsWith("public enum")) {
                    determineFileMainType(lineTrimmed);
                }
                if (isCurrentFileEnum()) scrubAndAddEnumFileLine(line);
                else scrubAndAddClassFileLine(line);
            }
            line = getReader().readLine();
        }
        addClassConstructor();
    }

    private void resetFileTrackingData() {
        setContentBuffer(new ArrayList<String>());
        setIncludeStjsArrayImport(false);
        setIncludeStjsDateImport(false);
        setCurrentFileEnum(false);
        setEndOfEnumsFound(false);
        setCurrentFileMainTypeDefined(false);
        setLastBufferLine(null);
        setCurrentFileName(null);
        setInitialClassDeclarationFound(false);
    }

    private void prependImportsToContentBuffer() {
        //getContentBuffer().add(0,"");
        if (getIncludeStjsArrayImport()) {
            getContentBuffer().add(0,"import " +  STJS_ARRAY_IMPORT + ";");
        }
        if (getIncludeStjsDateImport()) {
            getContentBuffer().add(0,"import " +  STJS_DATE_IMPORT + ";");
        }
        if (!isCurrentFileEnum()) {
            getContentBuffer().add(0,"import " +  EC_REMOTE_LD_IMPORT + ";");
        }
    }

    private void prependPackageToContentBuffer() {
        getContentBuffer().add(0,"");
        getContentBuffer().add(0,"package " +  getDestPackage() + ";");
    }

    private void prependHeaderToContentBuffer() {
        if (ADD_ASSIMILATER_HEADER) {
            getContentBuffer().add(0,"");
            getContentBuffer().add(0," **/");
            getContentBuffer().add(0," *");
            Calendar cal = Calendar.getInstance();
            getContentBuffer().add(0," * Assimilation Date: " + cal.getTime().toString());
            getContentBuffer().add(0," * Generated by JaxbToStjsAssimilater.");
            getContentBuffer().add(0," *");
            getContentBuffer().add(0,"/**");
        }
    }

    private void writeContentBufferToDestinationFile(String fileName) throws Exception {
        log("Writing content buffer to destination file...");
        setWriter(new PrintWriter(getDestFolder() + fileName));
        for (String s:getContentBuffer()) getWriter().println(s);
        getWriter().close();
    }

    private void assimilateFile(File f) {
        log("Assimilating: " + f.getAbsolutePath() + " -- Resistance is futile.");
        try {
            resetFileTrackingData();
            setCurrentFileName(f.getName());
            setReader(new BufferedReader(new FileReader(f.getAbsolutePath())));
            scrubFileContents();
            prependImportsToContentBuffer();
            prependPackageToContentBuffer();
            prependHeaderToContentBuffer();
            writeContentBufferToDestinationFile(f.getName());
        }
        catch (Exception e) {
            log("Exception assimilating '" + f.getName() + "' :" + e.toString());
            getErroredFileList().add(f);
        }
    }

    FilenameFilter javaFileFilter = new FilenameFilter() {
        public boolean accept(File dir, String name) {
            if (name.toLowerCase().equals("objectfactory.java")) return false;
            if (name.toLowerCase().endsWith(".java")) {
                return true;
            }
            else return false;
        }
    };

    private void buildFileList() {
        getFileList().clear();

        File sf = new File(getSourceFolder());
        File[] fa = sf.listFiles(javaFileFilter);
        for (File f:fa) getFileList().add(f);

//        File f = new File("C:\\TomsWorkFast\\intellijWorkspace\\JAXBToSTJS\\src\\sourceFiles\\QuantityOfProductVariantAtOperatingLocation.java");
//        getFileList().add(f);
//        f = new File("C:\\TomsWorkFast\\intellijWorkspace\\JAXBToSTJS\\src\\sourceFiles\\BreakdownRevisionIdentifier.java");
//        getFileList().add(f);
//        f = new File("C:\\TomsWorkFast\\intellijWorkspace\\JAXBToSTJS\\src\\sourceFiles\\MassRateUnit.java");
//        getFileList().add(f);
//        f = new File("C:\\TomsWorkFast\\intellijWorkspace\\JAXBToSTJS\\src\\sourceFiles\\ElectricCurrentUnit.java");
//        getFileList().add(f);
    }

    private void displayErroredFileList() {
        if (getErroredFileList().size() > 0) {
            System.out.println("**************************************************");
            System.out.println("Files that resisted assimilation: ");
            for (File f:getErroredFileList()) {
                System.out.println("-----" + f.getName());
            }
        }
    }

    private void displayAssimilationResults() {
        System.out.println("**************************************************");
        int numFiles = getFileList().size();
        int numFilesProcessed = numFiles - getErroredFileList().size();
        System.out.println(numFilesProcessed + " of " + numFiles + " files successfully assimilated.");
    }

    public void assimilate(String sourceFolder, String destFolder, String sourcePackage, String destPackage) {
        setSourceFolder(sourceFolder);
        setDestFolder(destFolder);
        setSourcePackage(sourcePackage);
        setDestPackage(destPackage);
        log("Building file list...");
        buildFileList();
        log("Assimilating files...");
        for (File f:getFileList()) assimilateFile(f);
        log("Displaying assimilated results...");
        displayAssimilationResults();
        log("Displaying errored files...");
        displayErroredFileList();
    }

    public static void main (String[] args) throws Exception {
        JaxbToStjsAssimilater jst = new JaxbToStjsAssimilater();
        jst.assimilate(SOURCE_FOLDER,DEST_FOLDER,SOURCE_PACKAGE,DEST_PACKAGE);
    }

}
