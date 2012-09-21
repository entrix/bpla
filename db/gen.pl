#!/usr/bin/perl -w

exit if $#ARGV < 1;

for my $i (1..$ARGV[1]) {
	$val = rand(100);
	$_   = int $val;
	print "INSERT INTO $ARGV[0] VALUES($i," 
								    .($_%4).", " 
									.($_%3).", "
									."DATE'1999-01-11', "
									.((100 - $_)%4).", "
									."$val, " 
									.(100 - $val).")\n";
}
