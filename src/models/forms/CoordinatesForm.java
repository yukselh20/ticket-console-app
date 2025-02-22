package models.forms;

import models.Coordinates;
import exceptions.InvalidFormException;
import exceptions.IncorrectInputInScriptException;
import utility.Interrogator;
import utility.console.Console;

import java.util.Scanner;

/**
 * Coordinates nesnesi oluşturmak için form.
 */
public class CoordinatesForm {
    private final Console console;
    private final Scanner scanner;

    public CoordinatesForm(Console console) {
        this.console = console;
        this.scanner = Interrogator.getUserScanner();
    }

    /**
     * Kullanıcıdan koordinat bilgilerini alır ve Coordinates nesnesini oluşturur.
     *
     * @return Oluşturulan Coordinates nesnesi.
     * @throws IncorrectInputInScriptException Girdi hatasında.
     * @throws InvalidFormException            Oluşturulan nesne doğrulanamazsa.
     */
    public Coordinates build() throws IncorrectInputInScriptException, InvalidFormException {
        console.println("Enter a coordinate X (float, > -661):");
        float x = readFloatGreaterThan(-661, "The value must be greater than -661.");

        console.println("Enter a coordinate Y (float, > -493):");
        float y = readFloatGreaterThan(-493, "The value must be greater than -493.");

        Coordinates coordinates = new Coordinates(x, y);
        if (!coordinates.validate()) {
            throw new InvalidFormException("Coordinates did not pass validation.");
        }
        return coordinates;
    }

    private float readFloatGreaterThan(double limit, String errorMsg) throws IncorrectInputInScriptException {
        while (true) {
            try {
                String line = scanner.nextLine().trim();
                float value = Float.parseFloat(line);
                if (value > limit) return value;
                else {
                    console.printError(errorMsg);
                    if (Interrogator.fileMode()) throw new IncorrectInputInScriptException();
                }
            } catch (NumberFormatException e) {
                console.printError("Enter a number in float format.");
                if (Interrogator.fileMode()) throw new IncorrectInputInScriptException();
            }
        }
    }
}
