package edu.vassar.cmpu203.triviagame.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class QuestionDatabase {
    ArrayList<Question> questions = new ArrayList<>();

    /**
     * Parses through a txt file and adds Questions to questions List
     * @param file
     */
    public void parseFile(File file) {

        String category = file.getName().toUpperCase();
        Scanner s = null;
        try {
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            return;
        }
        int added = 0;

        try {
            while (s.hasNextLine()) {
                String q = s.nextLine();
                if (q.length() > 0 && q.charAt(0) == '#') { //checks for start of a question
                    //System.out.println(q);
                    q = q.substring(3);
                    String correct = s.nextLine();
                    if (correct.charAt(0) != '^') {
                        continue;
                    }
                    correct = correct.substring(2); //scans correct answer
                    //System.out.println(correct);
                    String a = s.nextLine().substring(2); //scans answers choices
                    Choice aChoice = new Choice(a, a.equals(correct));
                    String b = s.nextLine().substring(2);
                    Choice bChoice = new Choice(b, b.equals(correct));
                    String c = s.nextLine();

                    if (c.isEmpty()) { //checks if only has two answers (i.e true or false, yes or no), then goes to next questions
                        s.nextLine();
                    } else {
                        //System.out.println(d);
                        c = c.substring(2);
                        Choice cChoice = new Choice(c, c.equals(correct));
                        String d = s.nextLine().substring(2);//scans last answer choice
                        Choice dChoice = new Choice(d, d.equals(correct));
                        Question ques = new Question(q, "normal", category, "mcq", aChoice, bChoice, cChoice, dChoice);
                        added++;
                        this.questions.add(ques);
                        //System.out.println(ques);
                    }

                }

            }
        } catch (Exception e) {
            //System.out.println(added);
        }
        System.out.println("Added " + added);


    }

    public QuestionDatabase() {
        File[] fileList = new File("/home/pcrisostomosuarez/Desktop/cs203/team-2c/intellij-project/src/src/question categories").listFiles();

        for (File f : fileList) {
            parseFile(f);
        }

    }
}