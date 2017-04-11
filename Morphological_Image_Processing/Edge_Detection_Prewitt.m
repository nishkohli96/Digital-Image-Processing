
grayImage=imread('C:\Users\HP\Downloads\lena.jpg');
grayImage=rgb2gray(grayImage);  
    figure(2);
    %% apply canny filter.
    prewittResult = edge(grayImage,'prewitt')
    imshow(prewittResult);

    