

public class tela1 {
    String[] Options = { "Inserir", "Consulta", "Excluir", "Alterar", "Listar", "Sair" };
    Screen scrn = new Screen();


    public int show(){
        return ( this.scrn.showOptionDialog(null, "opa", "w", 0, 0, null, Options, Options[0]) );
    }
}
