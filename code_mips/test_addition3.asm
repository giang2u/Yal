.text
main:
li $v0,5
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,7
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat multiplication 
	mult $t8, $v0
	
end :

