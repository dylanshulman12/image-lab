class Main {
  public static void main(String[] args) {
    
//    // Uncomment to run the ColorChooser main method
//    //ColorChooser.main(args);
//
//    int binary = 00000101;
//
//    int result = binary/4;
//
//    System.out.println(result);
//    // Uncomment to run the Steganography main method
//    //Steganography.main(args);

    Picture beach = new Picture ("beach.jpg");
    beach.explore();
    Picture copy = Steganography.testClearLow(beach);
    copy.explore();

    Picture copy3 = revealPicture(copy2);
    copy3.explore();

  }


}