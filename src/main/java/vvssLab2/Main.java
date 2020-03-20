package vvssLab2;

import vvssLab2.Repository.NoteRepo;
import vvssLab2.Repository.StudentRepo;
import vvssLab2.Repository.TemeRepo;
import vvssLab2.Service.ServiceNote;
import vvssLab2.Service.ServiceStudent;
import vvssLab2.Service.ServiceTeme;
import vvssLab2.UI.UI;
import vvssLab2.Validator.NotaValidator;
import vvssLab2.Validator.StudentValidator;
import vvssLab2.Validator.TemeValidator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
        StudentRepo rep=new StudentRepo(new StudentValidator(),"studenti.xml");
        TemeRepo repo=new TemeRepo(new TemeValidator(),"teme.xml");
        NoteRepo r=new NoteRepo(new NotaValidator());
        ServiceStudent srv=new ServiceStudent(rep);
        ServiceTeme serv=new ServiceTeme(repo);
        ServiceNote sv=new ServiceNote(r);
        UI ui=new UI(srv,serv,sv);
        ui.show();

    }
}
