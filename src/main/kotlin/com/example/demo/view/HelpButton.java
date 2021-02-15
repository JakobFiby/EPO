package com.example.demo.view;

import java.awt.Desktop;
import java.net.URI;

public class HelpButton {

    public static void main() throws Exception{
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://hakmistelbach.ac.at/"));
    }
}
