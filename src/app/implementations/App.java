package app;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class App {
    public static void main(String[] args) throws Exception {
        String datinha = "13/06/2000";
        String formato = "dd/MM/yyyy";
        Pessoa paulo = new Pessoa(null,null,null,null, 13/06/2000);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
        Date dataNascimento = simpleDateFormat.parse(datinha);
        System.out.println(simpleDateFormat.format(paulo.getDataNascimento()));
    }
}