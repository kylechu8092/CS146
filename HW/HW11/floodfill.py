def floodFill(self, image, sr, sc, color):
    if image[sr][sc] is color:
        return image
    self.fill(image, sr, sc, color, image[sr][sc])
    return image

def fill(self, image, sr, sc, color, startingColor):
    if sr < 0 or sc < 0 or sr >= len(image) or sc >= len(image[0]) or image[sr][sc] != startingColor:
        return
    image[sr][sc] = color
    self.fill(image,sr-1,sc,color,startingColor)
    self.fill(image,sr+1,sc,color,startingColor)
    self.fill(image,sr,sc-1,color,startingColor)
    self.fill(image,sr,sc+1,color,startingColor)

