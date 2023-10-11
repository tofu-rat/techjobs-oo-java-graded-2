package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.util.Locale;
import java.util.Objects;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
      public void testSettingJobId() {
         Job jobOne = new Job();
         Job jobTwo = new Job();

        assertNotEquals(jobOne.getId(),jobTwo.getId());
     }

     @Test
    public void testJobConstructorSetsAllFields(){
         Job productTester= new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

         assertEquals(productTester.getName(),"Product tester");
         
         assertEquals(productTester.getEmployer().getValue(),"ACME");
         assertTrue(productTester.getEmployer() instanceof Employer);

         assertEquals(productTester.getLocation().getValue(),"Desert");
         assertTrue(productTester.getLocation() instanceof Location);

         assertEquals(productTester.getPositionType().getValue(),"Quality control");
         assertTrue(productTester.getPositionType() instanceof PositionType);

         assertEquals(productTester.getCoreCompetency().getValue(),"Persistence");
         assertTrue(productTester.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test public void testJobsForEquality(){
        Job nasaCoder1 = new Job("software engineer", new Employer("NASA"), new Location("Desert"), new PositionType("coder"), new CoreCompetency("resilience"));
        Job nasaCoder2 = new Job("software engineer", new Employer("NASA"), new Location("Desert"), new PositionType("coder"), new CoreCompetency("resilience"));

        assertFalse(nasaCoder1.equals(nasaCoder2));
    }

    @Test public void testToStringStartsAndEndsWithNewLine(){
        Job testJob = new Job("Software Engineer", new Employer("NASA"), new Location("Desert"), new PositionType("Coder"), new CoreCompetency("Resilience"));
        String jobString = testJob.toString();

        assertTrue(jobString.startsWith(lineSeparator()));
        assertTrue(jobString.endsWith(lineSeparator()));

    }
    @Test public void testToStringContainsCorrectLabelsAndData(){

        Job testJob = new Job("Software Engineer", new Employer("NASA"), new Location("Desert"), new PositionType("Coder"), new CoreCompetency("Resilience"));

        String jobString = testJob.toString();

       assertEquals(lineSeparator() +
                "ID: " + testJob.getId()+ "\n"+
                "Name: Software Engineer\n" +
                "Employer: NASA\n" +
                "Location: Desert\n" +
                "Position Type: Coder\n" +
                "Core Competency: Resilience" +
                lineSeparator(), jobString);
    }

    @Test public void testToStringHandlesEmptyField(){

        Job testJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String jobString = testJob.toString();

        assertEquals(lineSeparator() +
                "ID: " + testJob.getId()+ "\n"+
                "Name: Data not available\n" +
                "Employer: Data not available\n" +
                "Location: Data not available\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Data not available" +
                lineSeparator(), jobString);

    }
}
