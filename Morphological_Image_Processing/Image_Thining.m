I= imread('C:\Users\HP\Downloads\lena.jpg');
level = graythresh(I);
Y=bwmorph(BW,'thin');
imshow(Y);
