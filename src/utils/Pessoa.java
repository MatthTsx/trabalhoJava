package utils;
public class Pessoa {
    public Object Codigo;
    public Object Name;
    public Object Bairro;
    public Object Cidade;
    public Object Estado;
    public Object CPF;


    public void setValue(int index, Object value){
        switch (index) {
            case 0:
                this.Codigo = value;
                break;
            case 1:
                this.Name = value;
                break;
            case 2:
                this.CPF = value;
                break;
            case 3:
                this.Cidade = value;
                break;
            case 4:
                this.Estado = value;
                break;
            case 5:
                this.Bairro = value;
                break;
        
            default:
                break;
        }
    }
}
