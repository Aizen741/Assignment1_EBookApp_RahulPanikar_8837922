package com.example.assignment1_ebookapp_rahulpanikar_8837922;
import java.util.Random;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView totalPriceTextView; // <-- Moved inside the class
    private CheckBox[] checkBoxes = new CheckBox[9];
    private Book[] books = {
            new Book("Regreting You ~ Colleen Hoover", "Morgan and her daughter Clara find themselves heartbroken and unexpectedly navigating a shattering loss. Both women spiral, finding their own path to resolution and peace, and discover that love can survive anything, even when it's wrapped in regret.","Price : 34 cad"),
            new Book("If You Tell ~ Gregg Olsen", "A harrowing, yet ultimately triumphant, true crime story of three sisters' journey to survive their horrific childhood, bound by a shared nightmare and battling to escape their sadistic mother.", "22 cad"),
            new Book("Power ~ Robert Greene", "A detailed and comprehensive guide to power dynamics and strategies, offering insights into attaining and understanding power, using historical examples to uncover the essential laws and dark secrets of influential power.","Price :54 cad"),
            new Book("Can't Hurt Me ~ David Goggins", "David Goggins narrates his astonishing life from perpetual victim to active duty Navy SEAL to world-class ultra athlete and world record holder, highlighting how to turn pain and struggle into mind-blowing success and true fulfillment.","Price : 19 cad"),
            new Book("Stop OverThinking ~ Ricky", "This book provides practical guidance on how to stop the spiral of overthinking and find mental clarity. It explores strategies to manage anxiety, make decisions confidently, and stop letting fear of the unknown control your life.","Price : 114 cad"),
            new Book("Blood in Breakwater ~ Jean", "A gritty thriller that dives deep into the dark and stormy waters of a coastal town. Engaging mysteries interweave with characters' personal lives, creating a turbulent and suspenseful ride for readers until the last page.","Price : 92 cad"),
            new Book("Ken Follett ~ Armor Light", "A riveting tale by Ken Follett set against the backdrop of a war-torn land. The protagonists navigate through a landscape where power, deceit, and courage collide, unfolding a story where every armor of light may cast a shadow.","Price : 33 cad"),
            new Book("Power Of Discipline ~ Daniel Walter", "Daniel Walter unveils the transformative power of discipline in our lives. The book elucidates how embracing discipline, managing time, and adopting a determined mindset can forge the path towards achieving our goals and realizing our fullest potential.","Price : 82 cad"),
            new Book("Red Lotus ~ Ande Li", "An exhilarating thriller that intertwines love, morality, and the desperate actions taken in the shadows. The protagonists' quest unfolds a complex web of secrets, ultimately unraveling startling truths and dangerous realities lurking beneath seemingly tranquil surfaces.","Price : 29 cad")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalPriceTextView = findViewById(R.id.totalPriceTextView); // <-- Initialize the TextView
        initializeBookSelection();
    }

    private void initializeBookSelection() {
        LinearLayout selectedBooksContainer = findViewById(R.id.selectedBooksContainer);
        int[] checkBoxIds = {
                R.id.checkBox1, R.id.checkBox2, R.id.checkBox3,
                R.id.checkBox4, R.id.checkBox5, R.id.checkBox6,
                R.id.checkBox7, R.id.checkBox8, R.id.checkBox9
        };
        for (int i = 0; i < checkBoxIds.length; i++) {
            int finalI = i;
            checkBoxes[i] = findViewById(checkBoxIds[i]);
            checkBoxes[i].setOnCheckedChangeListener((buttonView, isChecked) -> {
                updateSelectedBooks(selectedBooksContainer);
            });
        }
    }

    private void updateSelectedBooks(LinearLayout container) {
        container.removeAllViews();
        double totalCost = 0;  // Initialize the total cost to 0
        for (int i = 0; i < checkBoxes.length; i++) {
            if (checkBoxes[i].isChecked()) {
                TextView bookView = new TextView(this);
                bookView.setText(books[i].getName() + "\n" + books[i].getDescription() + "\n" + books[i].getPrice());
                container.addView(bookView);
                totalCost += extractPriceFromText(books[i].getPrice());  // Add the book's price to the total cost
            }
        }
        totalPriceTextView.setText(String.format("Total Cost: %.2f CAD", totalCost));
    }

    private double extractPriceFromText(String priceText) {
        return Double.parseDouble(priceText.split(" ")[2]);  // Extracts the numerical value of the price from the text
    }
}



