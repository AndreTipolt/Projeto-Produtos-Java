import classes.Vetor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception{


        Vetor vetor = new Vetor(4);

        try {

            vetor.adiciona(123);
            vetor.adiciona("Banana banana");

        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(vetor);
    }
}