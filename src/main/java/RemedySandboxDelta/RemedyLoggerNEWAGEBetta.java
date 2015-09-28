package RemedySandboxDelta;

// When using the logger it is very important that the RemedyTestResults folder exists in our Project! RR Sep27
/**
 * Created by Remedy on 9/27/2015.
 */
        import java.awt.*;
        import java.io.IOException;
        import java.util.logging.FileHandler;
        import java.util.logging.Level;
        import java.util.logging.Logger;
        import java.util.logging.SimpleFormatter;


public class RemedyLoggerNEWAGEBetta {


    static Logger remedyLoggerNEWAGEBetta = Logger.getLogger(RemedyLoggerNEWAGEBetta.class.getName());
    FileHandler remedyLoggerTextFileAttributes;



    public RemedyLoggerNEWAGEBetta() {



        // Configures Logger to be saved locally via text file RemedyLogger.txt 				(1 - 4) RR
        remedyLoggerNEWAGEBetta.setLevel(Level.ALL);
        // RemedyLogger output text file will be formated for readability 						(2 - 4) RR
        try {
            remedyLoggerTextFileAttributes = new FileHandler("RemedyTestResults/RemedyLoggerNEWAGEBetta.txt");
		} catch (SecurityException e) {
			e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Predetermines how the data will be formated in the Logger for ease of reading 		(3 - 4) RR
        remedyLoggerTextFileAttributes.setFormatter(new SimpleFormatter());
        // Configures the handling of the RemedyLogger text file combining name and attributes	(4 - 4) RR
        remedyLoggerNEWAGEBetta.addHandler(remedyLoggerTextFileAttributes);


    }



    protected void passed (String infoToLog) {
        remedyLoggerNEWAGEBetta.config("\r\n\r\n\t " + infoToLog + "\r\n\r\n");
    }


    protected void failed (String infoToLog) {
        remedyLoggerNEWAGEBetta.warning("\r\n\r\n\t " + infoToLog + "\r\n\r\n");
    }




    protected void remedyLoggerPassed(int remedyTestCaseIterator)
    {
        remedyLoggerNEWAGEBetta.config("\r\n\r\n\t Test Case ID: \t \t" + remedyTestCaseIterator + "\t - Passed" + "\r\n\r\n");
    }


    protected void remedyLoggerFailed(int remedyTestCaseIterator)
    {
        remedyLoggerNEWAGEBetta.warning("\r\n\r\n\t Test Case ID: \t \t" + remedyTestCaseIterator + "\t - FAILED" + "\r\n\r\n");
        Toolkit.getDefaultToolkit().beep();
    }


    protected void remedyLoggerExitSeuance(String scriptExecutionSummary)
    {
        remedyLoggerNEWAGEBetta.config(scriptExecutionSummary);
    }


    protected void remedyLoggerExitSequanceWarning()
    {
        remedyLoggerNEWAGEBetta.warning("Yes Arguments!");
    }



    protected void remedyExceptionHandler(int remedyTestCaseIterator, Exception e)
    {
        remedyLoggerNEWAGEBetta.warning(
                "\r\n\t Test Case Number: \t\t" + remedyTestCaseIterator + "\t" +
                        "- Caused an EXCEPTIION - Check Element precense and validity \r\n"
                        + "It is also possible that the corresponding Cell in Excel is empty or invalid" + "\r\n\t"
                        + e + "\r\n\t");
        Toolkit.getDefaultToolkit().beep();
    }


}
