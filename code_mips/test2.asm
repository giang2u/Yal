li $v0,0
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,5
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,6
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat addition 
	add $v0, $t8, $v0
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,23
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat soustraction 
	sub $v0, $t8, $v0
	sw $v0, ($sp)
	add $sp, $sp, -4 
	li $v0,7
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat multiplication 
	mult $t8, $v0
	mflo $v0
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat soustraction 
	sub $v0, $t8, $v0
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,5
	sw $v0, ($sp)
	add $sp, $sp, -4 
	li $v0,2
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat multiplication 
	mult $t8, $v0
	mflo $v0
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat addition 
	add $v0, $t8, $v0
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,1
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,5
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat Division 
	div $t8, $v0
	mflo $v0
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat addition 
	add $v0, $t8, $v0
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,0
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,0
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,0
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,0
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,0
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,0
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,0
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,0
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,0
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,0
	sw $v0, 0($sp)
	add $sp, $sp, -4 
	li $v0,5
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat soustraction 
	sub $v0, $t8, $v0
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat soustraction 
	sub $v0, $t8, $v0
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat soustraction 
	sub $v0, $t8, $v0
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat soustraction 
	sub $v0, $t8, $v0
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat soustraction 
	sub $v0, $t8, $v0
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat soustraction 
	sub $v0, $t8, $v0
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat soustraction 
	sub $v0, $t8, $v0
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat soustraction 
	sub $v0, $t8, $v0
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat soustraction 
	sub $v0, $t8, $v0
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat soustraction 
	sub $v0, $t8, $v0
	add $sp, $sp,4 
	lw $t8, ($sp) 
# Resultat soustraction 
	sub $v0, $t8, $v0
