import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Element {
    char[][] sprite;
    int spriteHeight;
    int spriteWidth;
    int x;
    int y;
//    int z;
//     the array of loaded elements
    static int numOfElements = 0;
    static Element[] myElements = new Element[255];

    //constructors
    Element(){
        ClearSprite();
    }
    Element(int x, int y, String filepath ) {
        loadSprite(filepath);
        this.x = x;
        this.y = y;
//        this.z = z;
        myElements[numOfElements] = this;
        numOfElements++;
    }


    private void ClearSprite() {
        for (int i = 0; i < spriteHeight; i++) {
            for (int j = 0; j < spriteWidth; j++) {
                sprite[i][j] = ' ';
            }
        }
    }

     void loadSprite(String filepath) {
        try {
            // Read the file contents into a byte array
            byte[] fileBytes = Files.readAllBytes(new File(filepath).toPath());

            // Convert the byte array to a character array
            String fileChars = new String(fileBytes);

            sprite = stringToMatrix(fileChars).clone();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  char[][] stringToMatrix(String input) {
        // First, split the string into rows
        String[] rows = input.split("\n");
        spriteHeight = rows.length;

        // Find the maximum width of any row
        spriteWidth = 0;
        for (String row : rows) {
            spriteWidth = Math.max(spriteWidth, row.length());
        }

        // Create the matrix with dimensions [height][width]
        char[][] matrix = new char[spriteHeight][spriteWidth];

        // Fill the matrix
        for (int i = 0; i < spriteHeight; i++) {
            char[] chars = rows[i].toCharArray();
            // Copy characters from this row
            for (int j = 0; j < spriteWidth; j++) {
                // If we've run out of characters in this row, fill with space
                matrix[i][j] = (j < chars.length) ? chars[j] : ' ';
            }
        }
        return matrix;
    }

}
