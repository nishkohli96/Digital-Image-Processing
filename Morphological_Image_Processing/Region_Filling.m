
I = imread('C:\Users\HP\Downloads\circles.png');
I=rgb2gray(I);
BW = imbinarize(I);
BW2 = imfill(BW,'holes');
figure
imshow(BW2)
title('Filled Image');