import javax.swing.*;
import java.io.FileNotFoundException;

/**
 * Created by mrproper on 13.10.2014.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        MainForm form=new MainForm();
        form.setVisible(true);
        form.setTitle("Знайди відмінності");
        form.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
