package main.FAANG.DesignPatterns.creational.AbstractFactory.factories;

import main.FAANG.DesignPatterns.creational.AbstractFactory.buttons.Button;
import main.FAANG.DesignPatterns.creational.AbstractFactory.buttons.MacOSButton;
import main.FAANG.DesignPatterns.creational.AbstractFactory.checkboxes.Checkbox;
import main.FAANG.DesignPatterns.creational.AbstractFactory.checkboxes.MacOSCheckbox;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
