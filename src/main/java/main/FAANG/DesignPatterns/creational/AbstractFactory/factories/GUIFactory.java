package main.FAANG.DesignPatterns.creational.AbstractFactory.factories;

import main.FAANG.DesignPatterns.creational.AbstractFactory.buttons.Button;
import main.FAANG.DesignPatterns.creational.AbstractFactory.checkboxes.Checkbox;

/**
 * Abstract factory knows about all (abstract) product types.
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
