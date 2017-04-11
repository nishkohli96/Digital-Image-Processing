
I = imread('C:\Users\HP\Downloads\circles.png');
s=strel('disk',4,0);%Structuring element
D=~im2bw(I);%binary Image
F=imerode(D,s);%Erode the image by structuring element
figure,imshow(D-F);title('Boundary extracted Image');
