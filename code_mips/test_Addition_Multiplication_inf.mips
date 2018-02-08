.text
main:
si0:		li $v0,5
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,2
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat addition 
	add $v0, $t8, $v0
	sw $v0, ($sp)
	add $sp, $sp, -4 
	li $v0,3
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat multiplication 
	mult $t8, $v0
	mflo $v0

	sw $v0,0($sp) 
	add $sp, $sp, -4 
		li $v0,5
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,2
	sw $v0, ($sp)
	add $sp, $sp, -4 
	li $v0,3
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat multiplication 
	mult $t8, $v0
	mflo $v0
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat addition 
	add $v0, $t8, $v0

	add $sp, $sp, 4 
	lw $t8,($sp) 
	sub $v0, $v0, $t8 
	bgtz $v0, sinon0
alors0:
	li $v0, 0
	j finsi0
sinon0:
	li $v0, 1
finsi0:  
end :

