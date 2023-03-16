package com.interstellarchef;

import com.interstellarchef.view.View;

public class Main {
    public static void main(String[] args) {
        View viewInstance = new View();
        viewInstance.printStartBanner();
        viewInstance.printGameIntro();
    }
}
