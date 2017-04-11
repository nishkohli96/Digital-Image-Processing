I = imread('C:\Users\HP\Downloads\lena.tif');
level = graythresh(I);
BW = imbinarize(I,level);
imshowpair(I,BW,'montage');