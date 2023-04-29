package com.example.demo;

import java.io.PrintWriter;
import java.io.FileWriter;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class TestListener extends RunListener {
    private PrintWriter writer;
 
    @Override
    public void testRunStarted(Description description) throws Exception {
        writer = new PrintWriter(new FileWriter("target/surefire-reports/custom-report.html"));
        writer.println("<html><body><table>");
        writer.println("<tr><td>Test Name</td><td>Result</td></tr>");
    }
 
    @Override
    public void testStarted(Description description) throws Exception {
        writer.println("<tr><td>" + description.getMethodName() + "</td><td>Started</td></tr>");
    }
 
    @Override
    public void testFinished(Description description) throws Exception {
        writer.println("<tr><td>" + description.getMethodName() + "</td><td>Passed</td></tr>");
    }
 
    @Override
    public void testFailure(Failure failure) throws Exception {
        writer.println("<tr><td>" + failure.getDescription().getMethodName() + "</td><td>Failed</td></tr>");
    }
 
    @Override
    public void testRunFinished(Result result) throws Exception {
        writer.println("</table></body></html>");
        writer.close();
    }
}

