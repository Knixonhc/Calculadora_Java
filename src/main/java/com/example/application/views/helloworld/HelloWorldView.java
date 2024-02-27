package com.example.application.views.helloworld;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Calculadora con Java")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends VerticalLayout {

    private TextField pantalla;
    private  Button btn1;
    private  Button btn2;
    private  Button btn3;
    private  Button btn4;
    private  Button btn5;
    private  Button btn6;
    private  Button btn7;
    private  Button btn8;
    private  Button btn9;
    private  Button btn0;
    private Button btnpunto;
    private Button BtnSumar;
    private Button BtnRestar;
    private Button BtnMultiplicacion;
    private Button BtnDivision;
    private Button BtnIgual;
    private Button BtnBorrar;
    private Button BtnDelete;
    private double num1 = 0;
    private String operacion = "";

    public HelloWorldView() {

        HorizontalLayout Fila1 = new HorizontalLayout();
        pantalla = new TextField();
        pantalla.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
        pantalla.setWidthFull();
        pantalla.setEnabled(false);
        Fila1.add(pantalla);

        HorizontalLayout Fila2 = new HorizontalLayout();
        btn1 = new Button("1", event -> Digitar("1"));
        btn2 = new Button("2", event -> Digitar("2"));
        btn3 = new Button("3", event -> Digitar("3"));
        Fila2.add(btn1, btn2, btn3);

        HorizontalLayout Fila3 = new HorizontalLayout();
        btn4 = new Button("4", event -> Digitar("4"));
        btn5 = new Button("5", event -> Digitar("5"));
        btn6 = new Button("6", event -> Digitar("6"));
        BtnSumar = new Button("+", event -> Suma());
        BtnRestar = new Button("-", event -> Resta());
        Fila3.add(btn4, btn5, btn6, BtnSumar, BtnRestar);

        HorizontalLayout Fila4 = new HorizontalLayout();
        btn7 = new Button("7", event -> Digitar("7"));
        btn8 = new Button("8", event -> Digitar("8"));
        btn9 = new Button("9", event -> Digitar("9"));
        BtnMultiplicacion = new Button("x", event -> Multiplicacion());
        BtnDivision = new Button("/", event -> Division());
        Fila4.add(btn7, btn8, btn9, BtnMultiplicacion, BtnDivision);

        HorizontalLayout Fila5 = new HorizontalLayout();
        btn0 = new Button("0", event -> Digitar("0"));
        btnpunto = new Button(".", event -> Digitar("."));
        BtnIgual = new Button("=", event -> Resultado());
        BtnBorrar = new Button("CE", event -> Borrar());
        BtnDelete = new Button("DEL", event -> Retroceso());
        Fila5.add(btn0, btnpunto, BtnIgual, BtnDelete, BtnBorrar);

        add(Fila1, Fila2, Fila3, Fila4, Fila5);

    }

    void Digitar(String numero){
        pantalla.setValue(pantalla.getValue().concat(numero));
    }
    void Borrar(){
        pantalla.setValue("");
    }
    void Retroceso() {
        String textopantalla = pantalla.getValue();
        if (textopantalla.length() > 0) {
            String nuevotexto = textopantalla.substring(0, textopantalla.length() - 1);
            pantalla.setValue(nuevotexto);
        }
    }
    void Suma() {
        num1 = Double.parseDouble(pantalla.getValue());
        operacion = "+";
        pantalla.setValue("");
    }

    void Resta() {
        num1 = Double.parseDouble(pantalla.getValue());
        operacion = "-";
        pantalla.setValue("");
    }

    void Multiplicacion() {
        num1 = Double.parseDouble(pantalla.getValue());
        operacion = "x";
        pantalla.setValue("");
    }

    void Division() {
        num1 = Double.parseDouble(pantalla.getValue());
        operacion = "/";
        pantalla.setValue("");
    }
    void Resultado() {
        double num2 = Double.parseDouble(pantalla.getValue());
        double resultado = 0;

        switch (operacion) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "x":
                resultado = num1 * num2;
                break;
            case "/":
                resultado = num1 / num2;
                break;
        }

        pantalla.setValue(Double.toString(resultado));
    }

}
