.text
main:
	li $v0,0
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,5
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat soustraction 
	sub $v0, $t8, $v0

	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,3
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat addition 
	add $v0, $t8, $v0

	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,6
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat soustraction 
	sub $v0, $t8, $v0
end :

