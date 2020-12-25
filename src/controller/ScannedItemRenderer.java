package controller;

import model.Product;
import model.ScannedProduct;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ScannedItemRenderer extends DefaultListCellRenderer implements ListCellRenderer<Object> {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        //return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        //assign value that is passed
        ScannedProduct is = (ScannedProduct) value;
        setText(String.format(is.getName() + "    Price: £%.2f", is.getPrice()) + "   X " + is.getQuantityScanned() + String.format("   Total: £%.2f",(is.getQuantityScanned()*is.getPrice())));

        try{
            //convert string to url
            URL url = new URL(is.getImage());
            //convert url to image
            Image urlToImg = ImageIO.read(url);
            //calculate new width given height = 220
            int newWidth = calcNewWidth(urlToImg);
                //resize image
            BufferedImage img = resizeImg(newWidth, 100, urlToImg);
            setIcon(new ImageIcon(img));
//            setIcon(new ImageIcon(urlToImg));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //set background and foreground colours to custom list row
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        setEnabled(true);
        setFont(list.getFont());
        return this;
    }

        private BufferedImage resizeImg(int width, int height, Image oldImage) {
            BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            try {
                Graphics2D graphics2D = resizedImage.createGraphics();
                graphics2D.drawImage(oldImage, 0, 0, width, height, null);
                graphics2D.dispose();
                return resizedImage;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return resizedImage;
        }

        private int calcNewWidth(Image img) {
            float currentWidth = img.getWidth(null);
            float currentHeight = img.getHeight(null);
            int newHeight = 100;
            int newWidth = Math.round(newHeight / (currentHeight / currentWidth));
            return newWidth;
        }

}
