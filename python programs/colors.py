import image
import sys
import random

img = image.Image("luther.jpg")
newimg = image.EmptyImage(img.getWidth(), img.getHeight())
win = image.ImageWin(img.getWidth(), img.getHeight())

for i in range(1, img.getWidth() - 1):
    for j in range(1, img.getHeight() - 1):
        neighbors = [img.getPixel(i-1,j-1),img.getPixel(i-1,j),img.getPixel(i-1,j+1),
                     img.getPixel(i,j-1),img.getPixel(i,j+1),img.getPixel(i+1,j-1),
                     img.getPixel(i+1,j),img.getPixel(i+1,j+1)]
        ch = random.randrange(0,7)
        new_p = neighbors[ch]
        newimg.setPixel(i, j, new_p)
newimg.draw(win)
win.exitonclick()
