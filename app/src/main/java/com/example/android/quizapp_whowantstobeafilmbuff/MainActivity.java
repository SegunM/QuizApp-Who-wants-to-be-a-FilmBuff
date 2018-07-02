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
    int passedQuestions = 0; //create the initial number of questions answered correctly
    int failedQuestions = 0; //create the initial number of questions answered wrongly
    String question1 = "1. Which of these titles is the highest grossing Nollywood movie of all time?";
    String question2 = "2. Genevieve Nnaji began her film acting career in which of these films?";
    String question3 = "3. Which of these movie directors often acts in his own films and has released a period film set in Nigeria in the 1960s.";
    String question4 = "4. Which of these actors starred in the 1993 blockbuster, Jurassic Park?";
    String question5 = "5. Who directed the 1960 Horror Film 'Psycho'?";
    String question6 = "6. Which of these titles is the highest grossing Hollywood movie of all time? ";

    String option1;
    String option2;
    String option3;

    //Start Screen Elements
    ImageView splashImage;
    EditText nameField;
    Button startButtton;

    //Question Screen Elements
    ScrollView scroll;
    RadioButton option1RadioButton, option2RadioButton, option3RadioButton; //initialize the radio buttons
    LinearLayout radiobuttonsContainer;
    LinearLayout checkboxesContainer;
    CheckBox option1CheckBox, option2CheckBox, option3CheckBox; //initialize the checkboxes
    ImageView headerImage; //the banner header image
    ImageView option1Image, option2Image, option3Image;
    TextView questionText;
    TextView option1Text, option2Text, option3Text;
    RadioGroup radioButtonsGroup;
    Button nextButton;

    //Scoring Elements
    TextView scoreText;
    Boolean question1IsAnswered = false;
    Boolean question2IsAnswered = false;
    Boolean question3IsAnswered = false;
    Boolean question4IsAnswered = false;
    Boolean question5IsAnswered = false;
    Boolean question6IsAnswered = false;

    Boolean isCorrect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //Hide the Questions View
        scroll = (ScrollView) findViewById(R.id.scroll);
        scroll.setVisibility(View.GONE);

        //Hide the Checkboxes by Default
        checkboxesContainer = (LinearLayout) findViewById(R.id.checkboxes_container);
        checkboxesContainer.setVisibility(View.GONE);

        /*
         * Manually set it so that when one button is clicked, the others remain unchecked...
         * */
        option1RadioButton =  (RadioButton) findViewById(R.id.option1_radiobutton);
        option2RadioButton =  (RadioButton) findViewById(R.id.option2_radiobutton);
        option3RadioButton =  (RadioButton) findViewById(R.id.option3_radiobutton);

        option1RadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                option1RadioButton.setChecked(true);
                option2RadioButton.setChecked(false);
                option3RadioButton.setChecked(false);
            }
        });

        option2RadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                option1RadioButton.setChecked(false);
                option2RadioButton.setChecked(true);
                option3RadioButton.setChecked(false);
            }
        });

        option3RadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                option1RadioButton.setChecked(false);
                option2RadioButton.setChecked(false);
                option3RadioButton.setChecked(true);
            }
        });

        //Initialize the header banner image
        headerImage = (ImageView) findViewById(R.id.header_image);
        headerImage.setImageResource(R.drawable.nollywood);

        //CONDITIONS
        if (questionCount < 0){
            //hide the splash and startup screen
            nameField.setVisibility(android.view.View.GONE);
            splashImage.setVisibility(android.view.View.GONE);
            startButtton.setVisibility(android.view.View.GONE);
        }

        if (questionCount >=1){
            //hide the splash and startup screen
            nameField = (EditText) findViewById(R.id.name_field);
            nameField.setVisibility(android.view.View.GONE);
            splashImage = (ImageView) findViewById(R.id.splash) ;
            splashImage.setVisibility(android.view.View.GONE);
            startButtton = (Button) findViewById(R.id.start_button);
            startButtton.setVisibility(android.view.View.GONE);

            scroll = (ScrollView) findViewById(R.id.scroll);
            scroll.setVisibility(View.VISIBLE); //show the questions view
        }

        // RADIO BUTTONS LOGIC
        radioButtonsGroup = (RadioGroup) findViewById(R.id.radiobuttons_group);
        radioButtonsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             public void onCheckedChanged(RadioGroup group, int checkedId) {

                 switch (checkedId) {
                     //FOR THE FIRST RADIO BUTTON
                     case R.id.option1_radiobutton:
                         // for each question, check if the answer is correct
                         if (questionCount == 1) {
                             Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try Again", Toast.LENGTH_LONG);
                             toast.show();
                             toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                         }

                         if (questionCount == 2) {

                             if (question2IsAnswered == true) {
                                 Toast toast = Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_LONG);
                                 toast.show();
                                 toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                             }
                             if (question2IsAnswered == false){
                                 score = score+1;
                                 displayScore(score);
                                 question2IsAnswered = true;
                             }
                         }

                         if (questionCount == 3) {
                             Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try Again", Toast.LENGTH_LONG);
                             toast.show();
                             toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                         }
                         if (questionCount == 5) {
                             Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try Again", Toast.LENGTH_LONG);
                             toast.show();
                             toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                         }

                         if (questionCount == 6) {
                             Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try Again", Toast.LENGTH_LONG);
                             toast.show();
                             toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                         }

                         break;
                     //FOR THE SECOND RADIO BUTTON
                     case R.id.option2_radiobutton:
                         // for each question check if the answer is correct
                         if (questionCount == 1) {
                             if (question1IsAnswered == true){
                                 Toast toast = Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_LONG);
                                 toast.show();
                                 toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                             }

                             if (question1IsAnswered == false){
                                 score = score+1;
                                 displayScore(score);
                                 question1IsAnswered = true;
                             }
                         }

                         if (questionCount == 2) {
                             Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try Again", Toast.LENGTH_LONG);
                             toast.show();
                             toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                         }
                         if (questionCount == 3) {

                             if (question3IsAnswered == true){
                                 Toast toast = Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_LONG);
                                 toast.show();
                                 toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                             }

                             if (question3IsAnswered == false){
                                 score = score+1;
                                 displayScore(score);
                                 question3IsAnswered = true;
                             }
                         }
                         if (questionCount == 5) {
                             Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try Again", Toast.LENGTH_LONG);
                             toast.show();
                             toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                         }

                         if (questionCount == 6) {
                             Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try Again", Toast.LENGTH_LONG);
                             toast.show();
                             toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                         }
                         break;

                     // FOR THE THIRD RADIO BUTTON
                     case R.id.option3_radiobutton:
                         // for each question check if the answer is correct
                         if (questionCount == 1) {
                             Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try Again", Toast.LENGTH_LONG);
                             toast.show();
                             toast.setGravity(Gravity.CENTER_VERTICAL,0,0);        }
                         if (questionCount == 2) {
                             Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try Again", Toast.LENGTH_LONG);
                             toast.show();
                             toast.setGravity(Gravity.CENTER_VERTICAL,0,0);        }

                         if (questionCount == 3) {
                             Toast toast = Toast.makeText(MainActivity.this, "Wrong! Try Again", Toast.LENGTH_LONG);
                             toast.show();
                             toast.setGravity(Gravity.CENTER_VERTICAL,0,0);        }

                         if (questionCount == 5) {
                             if (question5IsAnswered == true){
                                 Toast toast = Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_LONG);
                                 toast.show();
                                 toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                             }

                             if (question5IsAnswered == false){
                                 score = score+1;
                                 displayScore(score);
                                 question5IsAnswered = true;
                             }        }
                         if (questionCount == 6) {
                             if (question6IsAnswered == true){
                                 Toast toast = Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_LONG);
                                 toast.show();
                                 toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                             }

                             if (question6IsAnswered == false){
                                 score = score+1;
                                 displayScore(score);
                                 question6IsAnswered = true;
                             }        }
                         break;
                 }
             }
         }); // radioGroupEventListener

        //addEventListenerOnNextButton();

    } //end of the onCreate method


    /**
     * This method is called when the start quiz button is clicked.
     */
    public void startQuiz (View view){
        nameField = (EditText) findViewById(R.id.name_field);
        String userName = nameField.getText().toString();
        if (userName.matches("")){
            Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_LONG).show();
            return;
        }

        questionCount = questionCount + 1; //Increase the questions count
        updateQuestionCount(questionCount);

        //hide the splash and startup screen
        nameField = (EditText) findViewById(R.id.name_field);
        nameField.setVisibility(android.view.View.GONE);
        splashImage = (ImageView) findViewById(R.id.splash) ;
        splashImage.setVisibility(android.view.View.GONE);
        startButtton = (Button) findViewById(R.id.start_button);
        startButtton.setVisibility(android.view.View.GONE);

        //show the questions view
        scroll = (ScrollView) findViewById(R.id.scroll);
        scroll.setVisibility(View.VISIBLE);

        //set up the first question fields
        questionText = (TextView) findViewById(R.id.question_textview);
        questionText.setText(question1);

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

        option1RadioButton =  (RadioButton) findViewById(R.id.option1_radiobutton);
        option2RadioButton =  (RadioButton) findViewById(R.id.option2_radiobutton);
        option3RadioButton =  (RadioButton) findViewById(R.id.option3_radiobutton);

        option1RadioButton.setText(option1);
        option2RadioButton.setText(option2);
        option3RadioButton.setText(option3);

    }

    /**
     * This method is keeps the score.
     */
    //private int scoreChecker(boolean isCorrect){
        //if(isCorrect){
            //score = score+1;
            //Toast.makeText(this, "Correct!", Toast.LENGTH_LONG).show();
            //questionCount = questionCount + 1;
       // }
        //return score;
        //Log.d("The", "score is: " + score);
    //}

    /**
     * These methods are called when a radio button is clicked.
     */

    public void addEventListenerOnNextButton(){
        nextButton = (Button) findViewById(R.id.next_button);
        radioButtonsGroup = (RadioGroup) findViewById(R.id.radiobuttons_group);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option2RadioButton = (RadioButton) findViewById(R.id.option2_radiobutton);
                //find the radiobutton by returned id
                if (option2RadioButton.isChecked()){
                    Toast.makeText(MainActivity.this, "Pressed!", Toast.LENGTH_LONG).show();

                    //increase the question count by 1
                    questionCount = questionCount + 1;
                    if (questionCount == 2) {

                        radioButtonsGroup.clearCheck();

                        //set up the second question fields
                        questionText = (TextView) findViewById(R.id.question_textview);
                        questionText.setText(question2);

                        option1 = "Most Wanted";
                        option2 = "Pretty Woman";
                        option3 = "The Road to Yesterday";

                        option1RadioButton =  (RadioButton) findViewById(R.id.option1_radiobutton);
                        option2RadioButton =  (RadioButton) findViewById(R.id.option2_radiobutton);
                        option3RadioButton =  (RadioButton) findViewById(R.id.option3_radiobutton);

                        option1RadioButton.setText(option1);
                        option2RadioButton.setText(option2);
                        option3RadioButton.setText(option3);

                        //get images
                        option1Image = (ImageView) findViewById(R.id.option1_image);
                        option2Image = (ImageView) findViewById(R.id.option2_image);
                        option3Image = (ImageView) findViewById(R.id.option3_image);

                        option1Image.setImageResource(R.drawable.most_wanted);
                        option2Image.setImageResource(R.drawable.pretty_woman);
                        option3Image.setImageResource(R.drawable.road_to_yesterday);
                    }

                }
            }
        });

    }


    /**
     * These methods are called if we are on Question4, and a checkbox is checked.
     */
    public void checkBox1Clicked(View view){
            Toast.makeText(this, "Correct!", Toast.LENGTH_LONG).show();
            option3CheckBox = (CheckBox) findViewById(R.id.option3_checkbox);
            option3CheckBox.setChecked(false);
    }
    public void checkBox2Clicked(View view){
            Toast.makeText(this, "Correct!", Toast.LENGTH_LONG).show();
            option3CheckBox = (CheckBox) findViewById(R.id.option3_checkbox);
            option3CheckBox.setChecked(false);
    }
    public void checkBox3Clicked(View view){
            Toast.makeText(this, "Wrong! Try again", Toast.LENGTH_LONG).show();
            //uncheck the other checkboxes
            option1CheckBox = (CheckBox) findViewById(R.id.option1_checkbox);
            option2CheckBox = (CheckBox) findViewById(R.id.option2_checkbox);
            option1CheckBox.setChecked(false);
            option2CheckBox.setChecked(false);
    }


    /**
     * This method is called when the next button is clicked.
     */
    public void submitAnswer (View view) {
        //increase the question count by 1
        questionCount = questionCount + 1;

        //increase and display the score
        //score = score + 1;
        //displayScore(score);

        //clear any checked radio buttons
        radioButtonsGroup = (RadioGroup) findViewById(R.id.radiobuttons_group);
        radioButtonsGroup.clearCheck();

        if (questionCount == 2) {

            //set up the second question fields
            questionText = (TextView) findViewById(R.id.question_textview);
            questionText.setText(question2);

            option1 = "Most Wanted";
            option2 = "Pretty Woman";
            option3 = "The Road to Yesterday";

            option1RadioButton =  (RadioButton) findViewById(R.id.option1_radiobutton);
            option2RadioButton =  (RadioButton) findViewById(R.id.option2_radiobutton);
            option3RadioButton =  (RadioButton) findViewById(R.id.option3_radiobutton);

            option1RadioButton.setText(option1);
            option2RadioButton.setText(option2);
            option3RadioButton.setText(option3);

            //get images
            option1Image = (ImageView) findViewById(R.id.option1_image);
            option2Image = (ImageView) findViewById(R.id.option2_image);
            option3Image = (ImageView) findViewById(R.id.option3_image);

            option1Image.setImageResource(R.drawable.most_wanted);
            option2Image.setImageResource(R.drawable.pretty_woman);
            option3Image.setImageResource(R.drawable.road_to_yesterday);
        }
        if (questionCount == 3) {
            //set up the third question fields
            questionText = (TextView) findViewById(R.id.question_textview);
            questionText.setText(question3);

            option1 = "Ayo Makun";
            option2 = "Kunle Afolayan";
            option3 = "Tunde Kelani";

            option1RadioButton =  (RadioButton) findViewById(R.id.option1_radiobutton);
            option2RadioButton =  (RadioButton) findViewById(R.id.option2_radiobutton);
            option3RadioButton =  (RadioButton) findViewById(R.id.option3_radiobutton);

            option1RadioButton.setText(option1);
            option2RadioButton.setText(option2);
            option3RadioButton.setText(option3);

            //get images
            option1Image = (ImageView) findViewById(R.id.option1_image);
            option2Image = (ImageView) findViewById(R.id.option2_image);
            option3Image = (ImageView) findViewById(R.id.option3_image);

            option1Image.setImageResource(R.drawable.ayo_makun);
            option2Image.setImageResource(R.drawable.kunle_afolayan);
            option3Image.setImageResource(R.drawable.tunde_kelani);
        }
        if (questionCount == 4) {
            //set up the fourth question fields
            questionText = (TextView) findViewById(R.id.question_textview);
            questionText.setText(question4);
            option1 = "Jeff Goldblum";
            option2 = "Samuel L. Jackson";
            option3 = "Russell Crowe";

            option1CheckBox = (CheckBox) findViewById(R.id.option1_checkbox);
            option2CheckBox = (CheckBox) findViewById(R.id.option2_checkbox);
            option3CheckBox = (CheckBox) findViewById(R.id.option3_checkbox);

            option1CheckBox.setText(option1);
            option2CheckBox.setText(option2);
            option3CheckBox.setText(option3);

            //get images
            option1Image = (ImageView) findViewById(R.id.option1_image);
            option2Image = (ImageView) findViewById(R.id.option2_image);
            option3Image = (ImageView) findViewById(R.id.option3_image);

            option1Image.setImageResource(R.drawable.jeff_goldblum);
            option2Image.setImageResource(R.drawable.samuel_l_jackson);
            option3Image.setImageResource(R.drawable.russell_crowe);

            //turn on the Checkboxes
            checkboxesContainer = (LinearLayout) findViewById(R.id.checkboxes_container);
            checkboxesContainer.setVisibility(View.VISIBLE);

            //hide the RadioButtons
            radioButtonsGroup = (RadioGroup) findViewById(R.id.radiobuttons_group);
            radioButtonsGroup.setVisibility(View.GONE);
        }
        if (questionCount == 5) {
            //set up the fifth question fields
            questionText = (TextView) findViewById(R.id.question_textview);
            questionText.setText(question5);
            option1 = "Michael Bay";
            option2 = "Ridley Scott";
            option3 = "Alfred Hitchcock";

            option1RadioButton =  (RadioButton) findViewById(R.id.option1_radiobutton);
            option2RadioButton =  (RadioButton) findViewById(R.id.option2_radiobutton);
            option3RadioButton =  (RadioButton) findViewById(R.id.option3_radiobutton);

            option1RadioButton.setText(option1);
            option2RadioButton.setText(option2);
            option3RadioButton.setText(option3);

            //get images
            option1Image = (ImageView) findViewById(R.id.option1_image);
            option2Image = (ImageView) findViewById(R.id.option2_image);
            option3Image = (ImageView) findViewById(R.id.option3_image);

            option1Image.setImageResource(R.drawable.michael_bay);
            option2Image.setImageResource(R.drawable.ridley_scott);
            option3Image.setImageResource(R.drawable.alfred_hitchcock);
        }
        if (questionCount == 6) {
            //set up the sixth question fields
            questionText = (TextView) findViewById(R.id.question_textview);
            questionText.setText(question6);
            option1 = "Avengers: Age of Ultron";
            option2 = "Avatar: The Last Airbender";
            option3 = "Avatar";

            option1RadioButton =  (RadioButton) findViewById(R.id.option1_radiobutton);
            option2RadioButton =  (RadioButton) findViewById(R.id.option2_radiobutton);
            option3RadioButton =  (RadioButton) findViewById(R.id.option3_radiobutton);

            option1RadioButton.setText(option1);
            option2RadioButton.setText(option2);
            option3RadioButton.setText(option3);

            //get images
            option1Image = (ImageView) findViewById(R.id.option1_image);
            option2Image = (ImageView) findViewById(R.id.option2_image);
            option3Image = (ImageView) findViewById(R.id.option3_image);

            option1Image.setImageResource(R.drawable.avengers);
            option2Image.setImageResource(R.drawable.last_airbender);
            option3Image.setImageResource(R.drawable.avatar);
        }
        // change the banner image to Hollywood from questions 4 and up
        if (questionCount >= 4) {
            headerImage = (ImageView) findViewById(R.id.header_image);
            headerImage.setImageResource(R.drawable.hollywood);
        }

        if (questionCount > 4) {
            //Hide the Checkboxes and Show the Radio Buttons
            //hide the Checkboxes
            checkboxesContainer = (LinearLayout) findViewById(R.id.checkboxes_container);
            checkboxesContainer.setVisibility(View.GONE);
            //show the RadioButtons
            radioButtonsGroup = (RadioGroup) findViewById(R.id.radiobuttons_group);
            radioButtonsGroup.setVisibility(View.VISIBLE);
        }
        // If we've reached the maximum number of questions, end the quiz and show the score
        if (questionCount > 6) {
            //reset questionsCount
        }
    }//submitAnswer

    //------------------------------ SCORE METHODS ------------------------------------------------

    /*
    * This method displays the score
    * */
    private void displayScore(int score){
        scoreText = (TextView) findViewById(R.id.score_textview);
        scoreText.setText(""+ score);
    }

    private int updateQuestionCount(int questionCount){
        return questionCount;
    }


} //end of Main Activity
