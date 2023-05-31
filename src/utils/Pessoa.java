package utils;
public class Pessoa {
    Object Codigo;
    Object Name;
    Object Bairro;
    Object Cidade;
    Object Estado;
    Object CPF;


    public void setValue(int index, Object value){
        switch (index) {
            case 0:
                this.Codigo = value;
                break;
            case 1:
                this.Name = value;
                break;
            case 2:
                this.Bairro = value;
                break;
            case 3:
                this.Cidade = value;
                break;
            case 4:
                this.Estado = value;
                break;
            case 5:
                this.CPF = value;
                break;
        
            default:
                break;
        }
    }
}
