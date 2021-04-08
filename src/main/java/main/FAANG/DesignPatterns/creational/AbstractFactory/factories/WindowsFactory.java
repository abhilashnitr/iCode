package main.FAANG.DesignPatterns.creational.AbstractFactory.factories;

import main.FAANG.DesignPatterns.creational.AbstractFactory.buttons.Button;
import main.FAANG.DesignPatterns.creational.AbstractFactory.buttons.WindowsButton;
import main.FAANG.DesignPatterns.creational.AbstractFactory.checkboxes.Checkbox;
import main.FAANG.DesignPatterns.creational.AbstractFactory.checkboxes.WindowsCheckbox;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
