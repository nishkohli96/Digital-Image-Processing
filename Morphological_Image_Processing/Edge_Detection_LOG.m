    newImg=imread('C:\Users\HP\Downloads\lena.jpg');
    figure(1);
     %% create laplacian filter. 
    H = fspecial('laplacian');
     %% apply laplacian filter. 
    blurred = imfilter(newImg,H);
    imshow(blurred); title('Edge detected Image')
