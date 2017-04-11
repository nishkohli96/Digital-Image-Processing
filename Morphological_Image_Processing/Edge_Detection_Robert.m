
grayImage=imread('C:\Users\HP\Downloads\lena.jpg');
grayImage=rgb2gray(grayImage);  
    figure(2);
    %% apply canny filter.
    robertsResult = edge(grayImage,'roberts')
    imshow(robertsResult);

    