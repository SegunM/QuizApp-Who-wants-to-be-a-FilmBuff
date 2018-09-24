package com.example.android.quizapp_whowantstobeafilmbuff;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays a Film Trivia Quiz.
 */

public class MainActivity extends AppCompatActivity {

    //public variables
    int score = 0;
    int questionCount = 0; //create the initial number of questions
    int totalNumberOfQuestions = 7; //the total number of questions
    int question4Tally = 0; //create the initial number of checkboxes checked correctly for question 4

    String question1 = "1. Which of these titles is the highest grossing Nollywood movie of all time?";
    String question2 = "2. Genevieve Nnaji began her film acting career in which of these films?";
    String question3 = "3. Which of these movie directors often acts in his own films and has released a period film set in Nigeria in the 1960s.";
    String question4 = "4. Which of these actors starred in the 1993 blockbuster, Jurassic Park?";
    String question5 = "5. Who directed the 1960 Horror Film 'Psycho'?";
    String question6 = "6. Which of these titles is the highest grossing Hollywood movie of all time? ";
    String question7 = "7. Who directed Mission Impossible Fallout (2018)? ";

    String option1, option2, option3;
    String question2Option1, question2Option2, question2Option3;
    String question3Option1, question3Option2, question3Option3;
    String question4Option1, question4Option2, question4Option3;
    String question5Option1, question5Option2, question5Option3;
    String question6Option1, question6Option2, question6Option3;

    //Start Screen Elements
    ImageView splashImage;
    EditText nameField;
    Button startButtton;
    String userName;

    //Question Screen Elements
    ScrollView scroll;
    //initialize the radio buttons
    RadioButton option1RadioButton, option2RadioButton, option3RadioButton;
    RadioButton question2Option1RadioButton, question2Option2RadioButton, question2Option3RadioButton;
    RadioButton question3Option1RadioButton, question3Option2RadioButton, question3Option3RadioButton;
    RadioButton question5Option1RadioButton, question5Option2RadioButton, question5Option3RadioButton;
    RadioButton question6Option1RadioButton, question6Option2RadioButton, question6Option3RadioButton;
    LinearLayout questionsContainer;
    CheckBox option1CheckBox, option2CheckBox, option3CheckBox; //initialize the checkboxes
    ImageView headerImage, headerImage2; //the banner header image
    ImageView option1Image, option2Image, option3Image;
    ImageView question2Option1Image, question2Option2Image, question2Option3Image;
    ImageView question3Option1Image, question3Option2Image, question3Option3Image;
    ImageView question4Option1Image, question4Option2Image, question4Option3Image;
    ImageView question5Option1Image, question5Option2Image, question5Option3Image;
    ImageView question6Option1Image, question6Option2Image, question6Option3Image;
    ImageView question7Image;
    TextView question1Text;
    TextView question2Text;
    TextView question3Text;
    TextView question4Text;
    TextView question5Text;
    TextView question6Text;
    TextView question7Text;

    EditText question7NameField;
    String question7Answer;

    RadioGroup radioButtonsGroup;
    RadioGroup question2RadioButtonsGroup;
    RadioGroup question3RadioButtonsGroup;
    RadioGroup question5RadioButtonsGroup;
    RadioGroup question6RadioButtonsGroup;

    //Scoring Elements
    TextView scoreText;
    Boolean question1IsAnswered = false;
    Boolean question2IsAnswered = false;
    Boolean question3IsAnswered = false;
    Boolean question4IsAnswered = false;
    Boolean question5IsAnswered = false;
    Boolean question6IsAnswered = false;
    Boolean question7IsAnswered = false;
    String answer7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scroll = (ScrollView) findViewById(R.id.scroll);

        //Hide the Questions View
        questionsContainer = (LinearLayout) findViewById(R.id.questionsContainer);
        questionsContainer.setVisibility(View.GONE);

        /*
         * Manually set it so that when one button is clicked, the others remain unchecked...
         * */
        option1RadioButton = (RadioButton) findViewById(R.id.option1_radiobutton);
        option2RadioButton = (RadioButton) findViewById(R.id.option2_radiobutton);
        option3RadioButton = (RadioButton) findViewById(R.id.option3_radiobutton);

        question2Option1RadioButton = (RadioButton) findViewById(R.id.question2_option1_radiobutton);
        question2Option2RadioButton = (RadioButton) findViewById(R.id.question2_option2_radiobutton);
        question2Option3RadioButton = (RadioButton) findViewById(R.id.question2_option3_radiobutton);

        question3Option1RadioButton = (RadioButton) findViewById(R.id.question3_option1_radiobutton);
        question3Option2RadioButton = (RadioButton) findViewById(R.id.question3_option2_radiobutton);
        question3Option3RadioButton = (RadioButton) findViewById(R.id.question3_option3_radiobutton);

        question5Option1RadioButton = (RadioButton) findViewById(R.id.question5_option1_radiobutton);
        question5Option2RadioButton = (RadioButton) findViewById(R.id.question5_option2_radiobutton);
        question5Option3RadioButton = (RadioButton) findViewById(R.id.question5_option3_radiobutton);

        question6Option1RadioButton = (RadioButton) findViewById(R.id.question6_option1_radiobutton);
        question6Option2RadioButton = (RadioButton) findViewById(R.id.question6_option2_radiobutton);
        question6Option3RadioButton = (RadioButton) findViewById(R.id.question6_option3_radiobutton);

        option1RadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                option1RadioButton.setChecked(true);
                option2RadioButton.setChecked(false);
                option3RadioButton.setChecked(false);

                //Display a message telling the user their answer is wrong
                Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try again", Toast.LENGTH_LONG);
                toast.show();
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                //Deduct one point when the answer is wrong
                // the if statement ensures the deduction only happens if this specific question has been answered correctly
                // this avoids double negatives from occurring on the score.
                if (question1IsAnswered == true) {
                    score = score - 1;
                    displayScore(score);
                    question1IsAnswered = false;
                }
            }
        });

        option2RadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                option1RadioButton.setChecked(false);
                option2RadioButton.setChecked(true);
                option3RadioButton.setChecked(false);

                //QUESTION 1 IS CORRECT
                Toast toast = Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_LONG);
                toast.show();
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                //UPDATE QUESTION COUNT & SCORE
                if (question1IsAnswered == false) {
                    score = score + 1;
                    displayScore(score);
                    questionCount = questionCount + 1;
                    question1IsAnswered = true;
                }
            }
        });

        option3RadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                option1RadioButton.setChecked(false);
                option2RadioButton.setChecked(false);
                option3RadioButton.setChecked(true);

                //Display a message telling the user their answer is wrong
                Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try again", Toast.LENGTH_LONG);
                toast.show();
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                //Deduct one point when the answer is wrong
                // the if statement ensures the deduction only happens if this specific question has been answered correctly
                // this avoids double negatives from occurring on the score.
                if (question1IsAnswered == true) {
                    score = score - 1;
                    displayScore(score);
                    question1IsAnswered = false;
                }
            }
        });


        question2Option1RadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                question2Option1RadioButton.setChecked(true);
                question2Option2RadioButton.setChecked(false);
                question2Option3RadioButton.setChecked(false);

                //QUESTION 2 IS CORRECT
                Toast toast = Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_LONG);
                toast.show();
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                //UPDATE QUESTION COUNT & SCORE
                if (question2IsAnswered == false) {
                    score = score + 1;
                    displayScore(score);
                    questionCount = questionCount + 1;
                    question2IsAnswered = true;
                }

            }
        });

        question2Option2RadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                question2Option1RadioButton.setChecked(false);
                question2Option2RadioButton.setChecked(true);
                question2Option3RadioButton.setChecked(false);

                //Display a message telling the user their answer is wrong
                Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try again", Toast.LENGTH_LONG);
                toast.show();
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                //Deduct one point when the answer is wrong
                // the if statement ensures the deduction only happens if this specific question has been answered correctly
                // this avoids double negatives from occurring on the score.
                if (question2IsAnswered == true) {
                    score = score - 1;
                    displayScore(score);
                    question2IsAnswered = false;
                }
            }
        });

        question2Option3RadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                question2Option1RadioButton.setChecked(false);
                question2Option2RadioButton.setChecked(false);
                question2Option3RadioButton.setChecked(true);

                //Display a message telling the user their answer is wrong
                Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try again", Toast.LENGTH_LONG);
                toast.show();
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                //Deduct one point when the answer is wrong
                // the if statement ensures the deduction only happens if this specific question has been answered correctly
                // this avoids double negatives from occurring on the score.
                if (question2IsAnswered == true) {
                    score = score - 1;
                    displayScore(score);
                    question2IsAnswered = false;
                }
            }
        });

        question3Option1RadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                question3Option1RadioButton.setChecked(true);
                question3Option2RadioButton.setChecked(false);
                question3Option3RadioButton.setChecked(false);

                //Display a message telling the user their answer is wrong
                Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try again", Toast.LENGTH_LONG);
                toast.show();
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                //Deduct one point when the answer is wrong
                // the if statement ensures the deduction only happens if this specific question has been answered correctly
                // this avoids double negatives from occurring on the score.
                if (question3IsAnswered == true) {
                    score = score - 1;
                    displayScore(score);
                    question3IsAnswered = false;
                }
            }
        });

        question3Option2RadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                question3Option1RadioButton.setChecked(false);
                question3Option2RadioButton.setChecked(true);
                question3Option3RadioButton.setChecked(false);

                //QUESTION 3 IS CORRECT
                Toast toast = Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_LONG);
                toast.show();
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                //UPDATE QUESTION COUNT & SCORE
                if (question3IsAnswered == false) {
                    score = score + 1;
                    displayScore(score);
                    questionCount = questionCount + 1;
                    question3IsAnswered = true;
                }
            }
        });

        question3Option3RadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                question3Option1RadioButton.setChecked(false);
                question3Option2RadioButton.setChecked(false);
                question3Option3RadioButton.setChecked(true);

                //Display a message telling the user their answer is wrong
                Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try again", Toast.LENGTH_LONG);
                toast.show();
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                //Deduct one point when the answer is wrong
                // the if statement ensures the deduction only happens if this specific question has been answered correctly
                // this avoids double negatives from occurring on the score.
                if (question3IsAnswered == true) {
                    score = score - 1;
                    displayScore(score);
                    question3IsAnswered = false;
                }
            }
        });

        question5Option1RadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                question5Option1RadioButton.setChecked(true);
                question5Option2RadioButton.setChecked(false);
                question5Option3RadioButton.setChecked(false);

                //Display a message telling the user their answer is wrong
                Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try again", Toast.LENGTH_LONG);
                toast.show();
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                //Deduct one point when the answer is wrong
                // the if statement ensures the deduction only happens if this specific question has been answered correctly
                // this avoids double negatives from occurring on the score.
                if (question5IsAnswered == true) {
                    score = score - 1;
                    displayScore(score);
                    question5IsAnswered = false;
                }
            }
        });

        question5Option2RadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                question5Option1RadioButton.setChecked(false);
                question5Option2RadioButton.setChecked(true);
                question5Option3RadioButton.setChecked(false);

                //Display a message telling the user their answer is wrong
                Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try again", Toast.LENGTH_LONG);
                toast.show();
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                //Deduct one point when the answer is wrong
                // the if statement ensures the deduction only happens if this specific question has been answered correctly
                // this avoids double negatives from occurring on the score.
                if (question5IsAnswered == true) {
                    score = score - 1;
                    displayScore(score);
                    question5IsAnswered = false;
                }
            }
        });

        question5Option3RadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                question5Option1RadioButton.setChecked(false);
                question5Option2RadioButton.setChecked(false);
                question5Option3RadioButton.setChecked(true);

                //QUESTION 5 IS CORRECT
                Toast toast = Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_LONG);
                toast.show();
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                //UPDATE QUESTION COUNT & SCORE
                if (question5IsAnswered == false) {
                    score = score + 1;
                    displayScore(score);
                    questionCount = questionCount + 1;
                    question5IsAnswered = true;
                }
            }
        });

        question6Option1RadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                question6Option1RadioButton.setChecked(true);
                question6Option2RadioButton.setChecked(false);
                question6Option3RadioButton.setChecked(false);

                //Display a message telling the user their answer is wrong
                Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try again", Toast.LENGTH_LONG);
                toast.show();
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                //Deduct one point when the answer is wrong
                // the if statement ensures the deduction only happens if this specific question has been answered correctly
                // this avoids double negatives from occurring on the score.
                if (question6IsAnswered == true) {
                    score = score - 1;
                    displayScore(score);
                    question6IsAnswered = false;
                }
            }
        });

        question6Option2RadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                question6Option1RadioButton.setChecked(false);
                question6Option2RadioButton.setChecked(true);
                question6Option3RadioButton.setChecked(false);

                //Display a message telling the user their answer is wrong
                Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try again", Toast.LENGTH_LONG);
                toast.show();
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                //Deduct one point when the answer is wrong
                // the if statement ensures the deduction only happens if this specific question has been answered correctly
                // this avoids double negatives from occurring on the score.
                if (question6IsAnswered == true) {
                    score = score - 1;
                    displayScore(score);
                    question6IsAnswered = false;
                }
            }
        });

        question6Option3RadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                question6Option1RadioButton.setChecked(false);
                question6Option2RadioButton.setChecked(false);
                question6Option3RadioButton.setChecked(true);

                //QUESTION 6 IS CORRECT
                Toast toast = Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_LONG);
                toast.show();
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                //UPDATE QUESTION COUNT & SCORE
                if (question6IsAnswered == false) {
                    score = score + 1;
                    displayScore(score);
                    questionCount = questionCount + 1;
                    question6IsAnswered = true;
                }
            }
        });

        //Initialize the header banner image
        headerImage = (ImageView) findViewById(R.id.header_image);
        headerImage.setImageResource(R.drawable.nollywood);

        //CONDITIONS
        if (questionCount < 0) {
            //hide the splash and startup screen
            nameField.setVisibility(android.view.View.GONE);
            splashImage.setVisibility(android.view.View.GONE);
            startButtton.setVisibility(android.view.View.GONE);
        }

        if (questionCount >= 1) {
            //hide the splash and startup screen
            nameField = (EditText) findViewById(R.id.name_field);
            nameField.setVisibility(android.view.View.GONE);
            splashImage = (ImageView) findViewById(R.id.splash);
            splashImage.setVisibility(android.view.View.GONE);
            startButtton = (Button) findViewById(R.id.start_button);
            startButtton.setVisibility(android.view.View.GONE);

            questionsContainer.setVisibility(View.VISIBLE); //show the questions view
        }

    } //end of the onCreate method


    /**
     * This method is called when the start quiz button is clicked.
     */
    public void startQuiz(View view) {
        //for aesthetic reasons, return the scroll view to the top
        scroll = (ScrollView) findViewById(R.id.scroll);
        scroll.scrollTo(0, 0);

        nameField = (EditText) findViewById(R.id.name_field);
        userName = nameField.getText().toString();
        if (userName.matches("")) {
            Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_LONG).show();
            return;
        }


        questionCount = questionCount + 1; //Increase the questions count

        //hide the splash and startup screen
        nameField = (EditText) findViewById(R.id.name_field);
        nameField.setVisibility(android.view.View.GONE);
        splashImage = (ImageView) findViewById(R.id.splash);
        splashImage.setVisibility(android.view.View.GONE);
        startButtton = (Button) findViewById(R.id.start_button);
        startButtton.setVisibility(android.view.View.GONE);

        //show the questions view
        questionsContainer.setVisibility(View.VISIBLE);

        //set up the first question fields
        question1Text = (TextView) findViewById(R.id.question_textview);
        question1Text.setText(question1);

        //get images
        option1Image = (ImageView) findViewById(R.id.option1_image);
        option2Image = (ImageView) findViewById(R.id.option2_image);
        option3Image = (ImageView) findViewById(R.id.option3_image);

        option1Image.setImageResource(R.drawable.fifty);
        option2Image.setImageResource(R.drawable.wedding_party_2);
        option3Image.setImageResource(R.drawable.jenifa);

        //set text
        option1 = "Fifty";
        option2 = "The Wedding Party 2";
        option3 = "The Return of Jenifa";

        option1RadioButton = (RadioButton) findViewById(R.id.option1_radiobutton);
        option2RadioButton = (RadioButton) findViewById(R.id.option2_radiobutton);
        option3RadioButton = (RadioButton) findViewById(R.id.option3_radiobutton);

        option1RadioButton.setText(option1);
        option2RadioButton.setText(option2);
        option3RadioButton.setText(option3);

        //set up the second question fields
        question2Text = (TextView) findViewById(R.id.question2_textview);
        question2Text.setText(question2);

        question2Option1 = "Most Wanted";
        question2Option2 = "Pretty Woman";
        question2Option3 = "The Road to Yesterday";

        //get images
        question2Option1Image = (ImageView) findViewById(R.id.question2_option1_image);
        question2Option2Image = (ImageView) findViewById(R.id.question2_option2_image);
        question2Option3Image = (ImageView) findViewById(R.id.question2_option3_image);

        question2Option1Image.setImageResource(R.drawable.most_wanted);
        question2Option2Image.setImageResource(R.drawable.pretty_woman);
        question2Option3Image.setImageResource(R.drawable.road_to_yesterday);

        //question 2 radio buttons
        question2Option1RadioButton = (RadioButton) findViewById(R.id.question2_option1_radiobutton);
        question2Option2RadioButton = (RadioButton) findViewById(R.id.question2_option2_radiobutton);
        question2Option3RadioButton = (RadioButton) findViewById(R.id.question2_option3_radiobutton);
        question2Option1RadioButton.setText(question2Option1);
        question2Option2RadioButton.setText(question2Option2);
        question2Option3RadioButton.setText(question2Option3);

        //set up the third question fields
        question3Text = (TextView) findViewById(R.id.question3_textview);
        question3Text.setText(question3);

        question3Option1 = "Ayo Makun";
        question3Option2 = "Kunle Afolayan";
        question3Option3 = "Tunde Kelani";

        //get images
        question3Option1Image = (ImageView) findViewById(R.id.question3_option1_image);
        question3Option2Image = (ImageView) findViewById(R.id.question3_option2_image);
        question3Option3Image = (ImageView) findViewById(R.id.question3_option3_image);

        question3Option1Image.setImageResource(R.drawable.ayo_makun);
        question3Option2Image.setImageResource(R.drawable.kunle_afolayan);
        question3Option3Image.setImageResource(R.drawable.tunde_kelani);

        //question 3 radio buttons
        question3Option1RadioButton = (RadioButton) findViewById(R.id.question3_option1_radiobutton);
        question3Option2RadioButton = (RadioButton) findViewById(R.id.question3_option2_radiobutton);
        question3Option3RadioButton = (RadioButton) findViewById(R.id.question3_option3_radiobutton);
        question3Option1RadioButton.setText(question3Option1);
        question3Option2RadioButton.setText(question3Option2);
        question3Option3RadioButton.setText(question3Option3);

        // add the banner image to Hollywood from questions 4 and up
        headerImage2 = (ImageView) findViewById(R.id.header_image2);
        headerImage2.setImageResource(R.drawable.hollywood);

        //set up the fourth question fields
        question4Text = (TextView) findViewById(R.id.question4_textview);
        question4Text.setText(question4);
        question4Option1 = "Jeff Goldblum";
        question4Option2 = "Samuel L. Jackson";
        question4Option3 = "Russell Crowe";

        option1CheckBox = (CheckBox) findViewById(R.id.option1_checkbox);
        option2CheckBox = (CheckBox) findViewById(R.id.option2_checkbox);
        option3CheckBox = (CheckBox) findViewById(R.id.option3_checkbox);

        option1CheckBox.setText(question4Option1);
        option2CheckBox.setText(question4Option2);
        option3CheckBox.setText(question4Option3);

        //get images
        question4Option1Image = (ImageView) findViewById(R.id.question4_option1_image);
        question4Option2Image = (ImageView) findViewById(R.id.question4_option2_image);
        question4Option3Image = (ImageView) findViewById(R.id.question4_option3_image);

        question4Option1Image.setImageResource(R.drawable.jeff_goldblum);
        question4Option2Image.setImageResource(R.drawable.samuel_l_jackson);
        question4Option3Image.setImageResource(R.drawable.russell_crowe);


        //set up the fifth question fields
        question5Text = (TextView) findViewById(R.id.question5_textview);
        question5Text.setText(question5);
        question5Option1 = "Michael Bay";
        question5Option2 = "Ridley Scott";
        question5Option3 = "Alfred Hitchcock";

        //get images
        question5Option1Image = (ImageView) findViewById(R.id.question5_option1_image);
        question5Option2Image = (ImageView) findViewById(R.id.question5_option2_image);
        question5Option3Image = (ImageView) findViewById(R.id.question5_option3_image);

        question5Option1Image.setImageResource(R.drawable.michael_bay);
        question5Option2Image.setImageResource(R.drawable.ridley_scott);
        question5Option3Image.setImageResource(R.drawable.alfred_hitchcock);

        //question 5 radio buttons
        question5Option1RadioButton = (RadioButton) findViewById(R.id.question5_option1_radiobutton);
        question5Option2RadioButton = (RadioButton) findViewById(R.id.question5_option2_radiobutton);
        question5Option3RadioButton = (RadioButton) findViewById(R.id.question5_option3_radiobutton);
        question5Option1RadioButton.setText(question5Option1);
        question5Option2RadioButton.setText(question5Option2);
        question5Option3RadioButton.setText(question5Option3);

        //set up the sixth question fields
        question6Text = (TextView) findViewById(R.id.question6_textview);
        question6Text.setText(question6);
        question6Option1 = "Avengers: Age of Ultron";
        question6Option2 = "Avatar: The Last Airbender";
        question6Option3 = "Avatar";

        //get images
        question6Option1Image = (ImageView) findViewById(R.id.question6_option1_image);
        question6Option2Image = (ImageView) findViewById(R.id.question6_option2_image);
        question6Option3Image = (ImageView) findViewById(R.id.question6_option3_image);

        question6Option1Image.setImageResource(R.drawable.avengers);
        question6Option2Image.setImageResource(R.drawable.last_airbender);
        question6Option3Image.setImageResource(R.drawable.avatar);

        //question 6 radio buttons
        question6Option1RadioButton = (RadioButton) findViewById(R.id.question6_option1_radiobutton);
        question6Option2RadioButton = (RadioButton) findViewById(R.id.question6_option2_radiobutton);
        question6Option3RadioButton = (RadioButton) findViewById(R.id.question6_option3_radiobutton);
        question6Option1RadioButton.setText(question6Option1);
        question6Option2RadioButton.setText(question6Option2);
        question6Option3RadioButton.setText(question6Option3);

        //set up question 7
        question7Text = (TextView) findViewById(R.id.question7_textview);
        question7Text.setText(question7);

        //get image
        question7Image = (ImageView) findViewById(R.id.question7_image);
        question7Image.setImageResource(R.drawable.mission_impossible);

        question7NameField = (EditText) findViewById(R.id.question7_name_field);
        question7Answer = question7NameField.getText().toString();
    }

    /**
     * These methods are called if we are on Question 4, and a checkbox is checked.
     */
    public void checkBox1Clicked(View view) {
        Toast toast = Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_LONG);
        toast.show();
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        option3CheckBox = (CheckBox) findViewById(R.id.option3_checkbox);
        option3CheckBox.setChecked(false);
        question4Tally = question4Tally + 1;

        if (question4Tally == 2) {
            if (question4IsAnswered == false) {
                score = score + 1;
                displayScore(score);
                questionCount = questionCount + 1;
                question4IsAnswered = true;
            }
        }

    }

    public void checkBox2Clicked(View view) {
        //Toast.makeText(this, "Correct!", Toast.LENGTH_LONG).show();
        Toast toast = Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_LONG);
        toast.show();
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        option3CheckBox = (CheckBox) findViewById(R.id.option3_checkbox);
        option3CheckBox.setChecked(false);
        question4Tally = question4Tally + 1;

        if (question4Tally == 2) {
            if (question4IsAnswered == false) {
                score = score + 1;
                displayScore(score);
                questionCount = questionCount + 1;
                question4IsAnswered = true;
            }
        }
    }

    public void checkBox3Clicked(View view) {
        //Display a message telling the user their answer is wrong
        Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try again", Toast.LENGTH_LONG);
        toast.show();
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        //uncheck the other checkboxes
        option1CheckBox = (CheckBox) findViewById(R.id.option1_checkbox);
        option2CheckBox = (CheckBox) findViewById(R.id.option2_checkbox);
        option1CheckBox.setChecked(false);
        option2CheckBox.setChecked(false);

        //Deduct one point when the answer is wrong
        // the if statement ensures the deduction only happens if this specific question has been answered correctly
        // this avoids double negatives from occurring on the score.
        if (question4IsAnswered == true) {
            score = score - 1;
            displayScore(score);
            question4Tally = 0;
            question4IsAnswered = false;
        }
    }


    /**
     * This method is called when the submit button is clicked.
     */
    public void submitAnswer(View view) {
        // If we've reached the maximum number of questions, end the quiz and show the score
        if (score <= 3) {
            Toast toast = Toast.makeText(MainActivity.this, "Please retake the Quiz\n" + userName + " scored " + score + " of " + totalNumberOfQuestions, Toast.LENGTH_LONG);
            toast.show();
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        }
        if (score <= 6 && score > 3) {
            Toast toast = Toast.makeText(MainActivity.this, "A Good Attempt!\n" + userName + " scored " + score + " of " + totalNumberOfQuestions, Toast.LENGTH_LONG);
            toast.show();
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        }
        if (score == 7) {
            Toast toast = Toast.makeText(MainActivity.this, "Congratulations!\n" + userName + " scored " + score + " of " + totalNumberOfQuestions, Toast.LENGTH_LONG);
            toast.show();
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        }
    }//submitAnswer

    /**
     * This method is called when the reset button is clicked
     */
    public void resetQuiz(View view) {
        //reset all public variables
        nameField.setText("", TextView.BufferType.EDITABLE); //clear the name field
        score = 0;
        displayScore(score);
        questionCount = 0; //create the initial number of questions

        //show the splash and startup screen
        nameField.setVisibility(View.VISIBLE);
        splashImage.setVisibility(View.VISIBLE);
        startButtton.setVisibility(View.VISIBLE);

        //hide the questions container view
        questionsContainer.setVisibility(View.GONE);

        totalNumberOfQuestions = 7; //the total number of questions
        question4Tally = 0; //create the initial number of checkboxes checked correctly for question 4
        question1IsAnswered = false;
        question2IsAnswered = false;
        question3IsAnswered = false;
        question4IsAnswered = false;
        question5IsAnswered = false;
        question6IsAnswered = false;
        question7IsAnswered = false;

        //clear any checked radio buttons
        radioButtonsGroup = (RadioGroup) findViewById(R.id.radiobuttons_group);
        question2RadioButtonsGroup = (RadioGroup) findViewById(R.id.question2_radiobuttons_group);
        question3RadioButtonsGroup = (RadioGroup) findViewById(R.id.question3_radiobuttons_group);
        question5RadioButtonsGroup = (RadioGroup) findViewById(R.id.question5_radiobuttons_group);
        question6RadioButtonsGroup = (RadioGroup) findViewById(R.id.question6_radiobuttons_group);
        radioButtonsGroup.clearCheck();
        question2RadioButtonsGroup.clearCheck();
        question3RadioButtonsGroup.clearCheck();
        question5RadioButtonsGroup.clearCheck();
        question6RadioButtonsGroup.clearCheck();

        //uncheck all checkboxes
        option1CheckBox.setChecked(false);
        option2CheckBox.setChecked(false);
        option3CheckBox.setChecked(false);

        //clear the edit text field in question 7
        question7NameField.setText("", TextView.BufferType.EDITABLE); //clear the name field

        //for aesthetic reasons, return the scroll view to the top
        scroll = (ScrollView) findViewById(R.id.scroll);
        scroll.scrollTo(0, 0);
    }

    /**
     * This method is called when the done button is clicked
     */
    public void answerQuestion7(View view) {
        question7NameField = (EditText) findViewById(R.id.question7_name_field);
        question7Answer = question7NameField.getText().toString();
        /* If the answer is Christopher McQuarrie spelt in any case...*/
        if (question7Answer.equalsIgnoreCase("Christopher McQuarrie")) {
            //Display a message telling the user their answer is correct
            Toast toast = Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_LONG);
            toast.show();
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

            if (question7IsAnswered == false) {
                score = score + 1;
                displayScore(score);
                questionCount = questionCount + 1;
                question7IsAnswered = true;
            }
        } else {
            //Display a message telling the user their answer is wrong
            Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try again", Toast.LENGTH_LONG);
            toast.show();
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            if (question7IsAnswered == true) {
                score = score - 1;
                displayScore(score);
                question7IsAnswered = false; //prevents double score deductions
            }
        }
    }

    //------------------------------ SCORE METHODS ------------------------------------------------

    /*
     * This method displays the score
     * */
    private void displayScore(int score) {
        scoreText = (TextView) findViewById(R.id.score_textview);
        scoreText.setText("" + score);
    }

    private int updateQuestionCount(int questionCount) {
        return questionCount;
    }


} //end of Main Activity
