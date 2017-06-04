select  
ve.vodEventId ,  
g.genre,  
s.subGenre  
from vodEvent ve , ref_genre g , ref_subgenre s 
where ve.genre = g.genreId and ve.subGenre = s.subGenreId
and g.genre IN