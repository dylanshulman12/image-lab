import java.awt.Color;

class Steganography {



/**
 * Clear the lower (rightmost) two bits in a pixel.
 */



    public static void clearLow (Pixel p )
    {



        //get all the integer values first.
        int Red = p.getRed();
        int BinaryRepRed = Integer.parseInt(Integer.toBinaryString(Red));

        //remove right and replace with zeros
        int Altered_BinaryRepRed = (BinaryRepRed >> 2) << 2;

        //do a couple more times

        int Green = p.getGreen();
        int BinaryRepGreen = Integer.parseInt(Integer.toBinaryString(Green));
        int Altered_BinaryRepGreen = (BinaryRepGreen >> 2) << 2;

        int Blue = p.getBlue();
        int BinaryRepBlue = Integer.parseInt(Integer.toBinaryString(Blue));
        int Altered_BinaryRepBlue = (BinaryRepBlue >> 2) << 2;

    }

    public static Picture testClearLow(Picture p) {
        int w = p.getWidth();
        int h = p.getHeight();



        return p;
    }

    public static void setLow (Pixel p, Color c)
    {
        int redHigh = (c.getRed() & 192) >> 6;
        int greenHigh = (c.getGreen() & 192) >> 6;
        int blueHigh = (c.getBlue() & 192) >> 6;

        // Clear the lowest 2 bits
        int newRed = p.getRed() & 252;
        int newGreen = p.getGreen() & 252;
        int newBlue = p.getBlue() & 252;

        newRed |= (redHigh << 2);
        newGreen |= (greenHigh << 2);
        newBlue |= (blueHigh << 2);

        // Set the modified color values to the pixel
        p.setColor(new Color(newRed, newGreen, newBlue));
    }

    public static Picture testSetLow(Picture p, Color c) {
        Picture result = new Picture(p.width(), p.height());

        for (int y = 0; y < p.height(); y++) {
            for (int x = 0; x < p.width(); x++) {
                Pixel pixel = p.getPixel(x, y);
                setLow(pixel, c);
                result.setPixel(x, y, pixel);
            }
        }

        return result;
    }

    public static Picture revealPicture(Picture hidden) {
        Picture copy = new Picture(hidden);
        Pixel[][] pixels = copy.getPixels2D();
        Pixel[][] source = hidden.getPixels2D();
        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < pixels[0].length; c++)
            {
                Color col = source[r][c].getColor();
                //code implementation

                int red = (col.getRed() & 3) << 6;
                int green = (col.getGreen() & 3) << 6;
                int blue = (col.getBlue() & 3) << 6;
                Color newColor = new Color(red, green, blue);
                pixels[r][c].setColor(newColor);
            }
        }
        return copy;
    }

}