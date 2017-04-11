I = imread('C:\Users\HP\Downloads\circles.png');
bw = [0 0 0 0 0 0
      0 0 1 1 0 0
      0 1 1 1 1 0
      0 1 1 1 1 0
      0 0 1 1 0 0
      0 0 1 0 0 0];
  I=rgb2gray(I);
  BW = imbinarize(I);
interval = [0 -1 -1
            1  1 -1
            0  1  0];
 bw2 = bwhitmiss(BW,interval);
 imshow(bw2);