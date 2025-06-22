package rahulshettyacademy.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 1; // Define how many times you want to retry

    @Override
    public boolean retry(ITestResult result) {
        if(retryCount < maxRetryCount){
            retryCount++;

            return true;
        }
        return false;
    }
}
