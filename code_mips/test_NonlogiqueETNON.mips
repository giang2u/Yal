	li $v0,1
	beqz $v0, sinon0
alors0:
	li $v0, 0
	j finsi0
sinon0:
	li $v0, 1
finsi0: 

	sw $v0,0($sp) 
	add $sp, $sp, -4 
	li $v0,0
	beqz $v0, sinon1
alors1:
	li $v0, 0
	j finsi1
sinon1:
	li $v0, 1
finsi1: 

	add $sp, $sp, 4 
	lw $t8,($sp) 
	and $v0,$v0,$t8 

	sw $v0,0($sp) 
	add $sp, $sp, -4 
	li $v0,0
	beqz $v0, sinon2
alors2:
	li $v0, 0
	j finsi2
sinon2:
	li $v0, 1
finsi2: 

	add $sp, $sp, 4 
	lw $t8,($sp) 
	or $v0,$v0,$t8 