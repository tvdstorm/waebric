package waebric.beaver;

import waebric.ast.*;
import beaver.*;
import java.util.ArrayList;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "waebric.grammar".
 */
public class WaebricParser extends Parser {
	static public class Terminals {
		static public final short EOF = 0;
		static public final short IDCON = 1;
		static public final short LBRACE = 2;
		static public final short IF = 3;
		static public final short EACH = 4;
		static public final short LET = 5;
		static public final short COMMENT = 6;
		static public final short ECHO = 7;
		static public final short CDATA = 8;
		static public final short YIELD = 9;
		static public final short END = 10;
		static public final short NATCON = 11;
		static public final short RBRACE = 12;
		static public final short LBRACK = 13;
		static public final short TEXT = 14;
		static public final short SYMBOLCON = 15;
		static public final short IN = 16;
		static public final short SEMICOLON = 17;
		static public final short RPAREN = 18;
		static public final short ELSE = 19;
		static public final short DOT = 20;
		static public final short PLUS = 21;
		static public final short COMMA = 22;
		static public final short FILENAME = 23;
		static public final short PRETEXT = 24;
		static public final short DIRNAME = 25;
		static public final short ANDAND = 26;
		static public final short OROR = 27;
		static public final short LPAREN = 28;
		static public final short COLON = 29;
		static public final short MIDTEXT = 30;
		static public final short POSTTEXT = 31;
		static public final short RBRACK = 32;
		static public final short DEF = 33;
		static public final short SITE = 34;
		static public final short IMPORT = 35;
		static public final short ADDCHAR = 36;
		static public final short HASH = 37;
		static public final short DOLLAR = 38;
		static public final short EQ = 39;
		static public final short QUESTION = 40;
		static public final short NOT = 41;
		static public final short MOD = 42;
		static public final short STRCON = 43;
		static public final short DIV = 44;
		static public final short MODULE = 45;
		static public final short LIST = 46;
		static public final short RECORD = 47;
		static public final short STRING = 48;
	}

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9pjcNUSL4KInsjcDhAhnouSe0U84GHENG6L9A3aZ21HWe0eMP1e1Wo8A08I9Ib19MT1G56" +
		"9AY0eY0HH4KodftXdrhvlz#jvysRUOvdFVVpSFySKzQhxLzM$hgxNBoqYcNFKvaIH2z6mRK" +
		"VKINbDtbOdiVkb2KYQb9E$OmSQhBoaIuPaoY3f9tUgnu94hh6sBifOgIMLfPB5kaaFO$FK8" +
		"AaWDyeDyeBrR9STibE6gCSJHUPpF6dR1z4trQyw5x9vZ5vLav$sNIdNoLLojNIIQdRigq4Y" +
		"jQtTWEhyEajRoR9O5SdcED33TQvTwsj18grjwttQhMIHj87hWYWcbvYO6DSKwtaYI6IcRHs" +
		"aJPsaFLobevXCCp6rNBOwrZCsK9wnzXirLih8vVeSg2yTJ5vql9o3R#mvA6#ZVRKtTQrexJ" +
		"pqUaIVppSjLbrc6PidDHmkzRKTDoPGlhPsXXeZpUGcosKmkLcw6fkdPbYkTstqwq4Yxrbx6" +
		"xfVxRTSZlSzwMjyUTBVhd60zVZslzdtNrZx6VgftENiSekbIehU$sxboyfWPq#uI6Df82sa" +
		"eGoLnR94bieoMIuhPANSA$V9$J8YOBx7qQQsFH7Tx5ufJz1xKfhB9EmecSaANhKhSEOyAX$" +
		"An$AAZ6F6db9VYaXHAIRdoT#ak9IGN2aaXULXELzovA$o5tbGFI9JfRRCa4Uaf5mcasMiZ9" +
		"T7POpwbhL#orghMAPDWKmNmRGAfcVKKh$8i#XpibeknYvGd$lgiIQm7i#hDuA4UZYjpsX7c" +
		"QwrlkOoHrhA2wPAz#IRSJsRyKArAK2#G5yWuutOOVAIskJEL5CD0rcJP5tFIRR#ISPDLwy4" +
		"olEEbLfeDDEE5bidwrN##w2WvSylvb8dnjnFepFSOSvVJ#SkQ#HkuzzgUpFf6qGz6Ot8Tuv" +
		"wTewjWVAxjS#ghMu6RrZipI3XcU7ORHplbzUbW7mWxrhlba2vpzfxrHPtZWaEbc$cSstcdw" +
		"fFvIDpvJqjU#LptTAO8xBF70$Q$d5rNDuto2ToE8Ov8aVCyP3jVw8#aHa6EI4dOvYL1ytn0" +
		"TlxM7qiOaQ8OntC4H3tY7oaFeeYNimH4FU875F7eeWNSmJ4FI8VgW#ZY1Tp1CGz8YVKYIZY" +
		"nHm1SO$8KNKqYdWnHq3S8t9O7OuYNimH4FU87557eeWNipBS#ezOEpoAH37$JiApHVqMRKk" +
		"Zs8urddq#6QpsuJ5juf#YFrXssnsxJth90$7tPMBoKEUEx#6MKcWNjJTHuDuhUw9jVczvhg" +
		"6zbd$j6VXhoYxriFe3$er#uJcnaUU4hib6z4Um3Nx1iq7zOKItVw3tib$ml0o35jt#DxtrV" +
		"i6p7WOjklrFUklyWcST35fq#r$qNl8BdfTWqABR3z5RwnSyQs7GejkAtWI$u9a0WvO9fXuJ" +
		"r7Y$W8zNpc#yUjJqdWgGHxKQbgVKI7ES5Y0ZjPgeQSvHJV8B#2GvRkxOazHetLDF1yXehOR" +
		"bQUUefle5VAhPHzQ2JVGB#4GRDT4vgYb#0PzYewOuHpNPB#2JRTHavwYc#mLykesQxXpL6h" +
		"#0hx5HQvoZMkqNyDKsQhLpLAly0hxAHgroZcgbNy1NsgYLpb6jy0lu2XkrmZcgvNu1NswZb" +
		"Zj7jSmluCjir3Bd6FXk9bgDtrZrebhW5$05DifOzPnQuXVm9JPgYLhi5$35rhzOBV8B#2Bh" +
		"NwGM#WLyeVKlL7Fy0Zx7#kUesNu1dstzizKilu3FilvPQfnVmCTP$xWpLKdDzmluVEkVh#R" +
		"v1NoUzSzJS$q2FjVwvwf$1CWfln1xohntERztk9TVeU$b6h5lP9hFxQdl$OBlUud#RWduHl" +
		"XERLVRtQV4Q9lZTZLAuyWsPBiSCr$WszLGVAD0HXbycngAR6E0zcvpMORBtUPzw$O0P6HY1" +
		"cQ#x$oPWHu0lzNbc6rcEI3T0rVnbLzidFV9w9ybUSJ3etQgdMvLE$15fzUmKwkHN$Y#tMcV" +
		"l#r0txOnElyFr2wroupBamFs6rXZRsaSsO7iKhyOsQrs6#OTMhLWTsDt6u$#tZT#yqsfutw" +
		"2SvYTDq$ws9RszfOk2N7YnaLRvAX#qkB6$Hp8rylmwLylJvoV3w$wsOZpNkIisNh1HjWtfe" +
		"SqYnhXoMy4zHlXuxFUM9oNB#2DvsLr3zWMlYPrtG$1Umz8EQVFkiHWGwIFUWVPe$OGtLiD0" +
		"Gb9M2AI8gcIPlyMbYjPZ3b7pkKxhXrV2#Vp1L6OhwxEj8j9MzFMNnGbvG96Ts7NTfLB#Eww" +
		"B82h05n5B5Sku$LO7LNAVfje3isL9ODiLCXoNS7QhfAofyalsutEaSjPY#OjOlBBTlFBeou" +
		"LfA9KmfDVVeqJyciYJObqyclFjsCyLu5ykNfRhcou1aX7mrNSSXNX2ooUgs##N24FbwvJF5" +
		"T1mnNoi2N3fUkLPyQ5MMyyLnOs$Xm4S$MoKSNX2Xa9SmuShiPIsdALI8ghe2Ul7AuwBrSkz" +
		"$3ul7BovMfdesuXhhF9BSQL8mqjLoYflDhQgAACFC$TvGvN3#xiyUSnotB5a6laMgxCBAaY" +
		"LQMQL9VhfGPV9RMuOc$aVFhdp26skRlA76djNYdbc3D7Eg7E#SxYcU34ENEsa9kafVIpCrO" +
		"EdB6sr96wKa$gImDMrv6p5BJgecIcTtmoJ0K26Nh2K9hSst36Mj5Ah4UtGCxSqvo3Q3rAcp" +
		"qRPNBEWLEFaAbIzwGoRXKuIouP5x8Pvy9Oo3EJlkzrIxgkVtPSS4qAnLt7yJNHrtNnfFYJY" +
		"T7p#$TpjkTUcIjtsljk8LChhONiSw5KqdFuroXsZa81Qyp$xbQ64MMaaLme5yd5#OueuncH" +
		"E4UocJjNNdDsbjDAh4x8LaV7XanrIZ2tKvrOR7yJEz0NMvvi4cDBcDWIiLYbTAp#D4#C1I6" +
		"MuzdOf6ETynQDTU8IOdsx2O#xOyrSxcwYLopuxGLFB5xF4Tsn0V6QFneVntrRCB$9vwueFx" +
		"r6dlsTD3#Z2h2geFpjSy9m5qI5wpGW2a#sNTN$IHIzCqQPNc2Kjwh9HPrXHkSkzgTmEN$yE" +
		"njrDieVTTR$l$UVzfetJpSphhXxB$SyRMZ5FGbFFo#jqgUTsVCKCf5PuD6tqh3x5Lt4p5KK" +
		"xtdMgvzqiVaJtoqh1o01JwleEdrFiMoaWuV3cQL3ilKBmFv4nAsgRNkUkKA5ScrRltFasdS" +
		"Kp$kAgN5X6rFA4#$Kstcs#9ZDgBZ8k0pql0sjDqkQUU9kbcAUkCAUN6Cj7HS$RpvySVCcoH" +
		"TNexWT1fhZuVFki3Y##8h7yod$6qzqPthV$QBzXlHBcNFJpBm7elHkDZ4YNpuevl$OzFyBT" +
		"nA9DC1s5KbvJYJr7BGKMW6j2pv697sFI4OsxIV1sec4VW7xG2GCLphx8Vq2z4gq1jWWOiv5" +
		"BqGhelNGzcXVL4yx2RsEkN#4SnHZcj6VItiixSwqDw0whwFCqmTxCJQJ7ATZTs6NezlG8#W" +
		"fSivWB5nwNIabHJBJwA#ZpToXakQlwfBIa3Ovocmi#MRo$flHbl7Ob2xe47nRmSazW$pI#u" +
		"CnHmfvf4mcR$q$RAdyMy1ulQRrn3p0Mcl1KPqnQy6hqcvDUmUw6oNFpFEnh2Fz16tcpoY2N" +
		"eeUfty5dDGeL8SsjPOrj3kWd8VC6z2xuUllxDFmM$W7ey$W7ufz3Ql$UlePTZpAEGlf$z#3" +
		"EqGjG$25E4#PzwBKFtqSojhJbw6lCdyJ$4jOnzjOrf99tkmJIVyLdnv77kmLIJs6VoMMEeV" +
		"ceyoRHXrIbcAB4QjnQfrM3li6zdhi0SR2A$Wog6Cu1xm5EFKAXU3k1TO8$mzO#XcpmDaxVA" +
		"5Ac7CNfXqkI$yhR4UKVHEY7cdTKTQUndvCcubItpGz9$EbVK5SFtGBglaFeJkPY$dvif2Cv" +
		"wabvps5EIE5YVyDMmKV#pYCFtCWRVPAXFmZUg$LH5kYRPYRQo65VH7YMaZX$6Umpp8VmdSh" +
		"EfN#SEnYQiHUpTXCctfbm9zv2ME#eQ$hpDfJmoZj3EeM6aPRnqv3sI#PN7#HEIZxACBvY6p" +
		"4VnATOA$JTr2znohO$cPj4vLV6TRJFjOFhmoAIrPPxr37XjxrS6xnpBV3#ll4ZqlVS9hybd" +
		"buBlBWbJpjmvwODgVFBVo3dVltCwz33bbRpODrzRH7UtWNnu$DqD$AfsoxiBxMFB57FN6hR" +
		"JvbpvHFiWhNKWy$zxkK$PwvsU$fdoV74sdknqHVapCiryWOdbaVV1FpNPF0qTBcTD3F5Ixr" +
		"twqlR6kMsTJsoziv1YVCNT8pPgdN5yDJvbkxEM5iarWxb1qyDjB24pFEWpUEjLFNvhyMytj" +
		"SUl3qxi6RmUtqRgSzY3UhTjZEHYFI5XlLMuchZwsFrK$W1kQlzgdIaNSnhNU0tS4O$NVWLj" +
		"YUnFN4vj6lP3HYz6hQyHenMf5s1RINqOYqnxR7DaPlCHgIvbZzrbePxWv6GzBRQ5W6CFy0s" +
		"ds8QO9jWcrgDCIxRfXttf3HPaRrMvX#QeHu4mvBNMn#sZqVhHsWRJpQAK7xMQr5xMxW3VP6" +
		"j3NQ5wmlkTG4hqBUrT7hqHfeLRGQlZf68wxMezyDRHYdASRsXwy$LZyj1jBkIdmBR0liJMX" +
		"Beo6vqwEDZAQWOPv44RcDlgCH6VmV5zXdu0==");

	public WaebricParser() {
		super(PARSING_TABLES);
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		switch(rule_num) {
			case 0: // lst$moduleelement = moduleelement
			{
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
			}
			case 1: // lst$moduleelement = lst$moduleelement moduleelement
			{
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2]); return _symbols[offset + 1];
			}
			case 4: // module = MODULE moduleid.i opt$lst$moduleelement.e
			{
					final Symbol _symbol_i = _symbols[offset + 2];
					final Cons i = (Cons) _symbol_i.value;
					final Symbol _symbol_e = _symbols[offset + 3];
					final ArrayList e = (ArrayList) _symbol_e.value;
					return new Module(i,e);
			}
			case 5: // moduleid = idcons.i
			{
					final Symbol _symbol_i = _symbols[offset + 1];
					final Cons i = (Cons) _symbol_i.value;
					return new Module_id(i);
			}
			case 6: // idcons = IDCON.i
			{
					final Symbol _symbol_i = _symbols[offset + 1];
					final String i = (String) _symbol_i.value;
					return new Idconsa(i);
			}
			case 7: // idcons = idcons.a DOT IDCON.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Cons a = (Cons) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final String b = (String) _symbol_b.value;
					return new Idconslist(a,b);
			}
			case 11: // import = IMPORT moduleid.m
			{
					final Symbol _symbol_m = _symbols[offset + 2];
					final Cons m = (Cons) _symbol_m.value;
					return new Import(m);
			}
			case 12: // lst$statement = statement
			{
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
			}
			case 13: // lst$statement = lst$statement statement
			{
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2]); return _symbols[offset + 1];
			}
			case 16: // functiondef = DEF IDCON.i formals.f opt$lst$statement.s END
			{
					final Symbol _symbol_i = _symbols[offset + 2];
					final String i = (String) _symbol_i.value;
					final Symbol _symbol_f = _symbols[offset + 3];
					final Cons f = (Cons) _symbol_f.value;
					final Symbol _symbol_s = _symbols[offset + 4];
					final ArrayList s = (ArrayList) _symbol_s.value;
					return new Def(i,f,s);
			}
			case 17: // assignment = IDCON.i EQ expression.e SEMICOLON
			{
					final Symbol _symbol_i = _symbols[offset + 1];
					final String i = (String) _symbol_i.value;
					final Symbol _symbol_e = _symbols[offset + 3];
					final Cons e = (Cons) _symbol_e.value;
					return new Var_bind(i,e);
			}
			case 18: // assignment = IDCON.i assignmentformals.f EQ statement.s
			{
					final Symbol _symbol_i = _symbols[offset + 1];
					final String i = (String) _symbol_i.value;
					final Symbol _symbol_f = _symbols[offset + 2];
					final Cons f = (Cons) _symbol_f.value;
					final Symbol _symbol_s = _symbols[offset + 4];
					final Cons s = (Cons) _symbol_s.value;
					return new Func_bind(i,f,s);
			}
			case 19: // formals = 
			{
					return new Empty();
			}
			case 20: // formals = LPAREN formallist.f RPAREN
			{
					final Symbol _symbol_f = _symbols[offset + 2];
					final Cons f = (Cons) _symbol_f.value;
					return new Formals(f);
			}
			case 21: // formallist = IDCON.i
			{
					final Symbol _symbol_i = _symbols[offset + 1];
					final String i = (String) _symbol_i.value;
					return new Formal_a(i);
			}
			case 22: // formallist = IDCON.a COMMA formallist.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final String a = (String) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Cons b = (Cons) _symbol_b.value;
					return new Formallist(a,b);
			}
			case 23: // assignmentformals = LPAREN RPAREN
			{
					return new Emptyformallist();
			}
			case 24: // assignmentformals = LPAREN formallist.f RPAREN
			{
					final Symbol _symbol_f = _symbols[offset + 2];
					final Cons f = (Cons) _symbol_f.value;
					return new Assignmentformals(f);
			}
			case 25: // var = IDCON.i
			{
					final Symbol _symbol_i = _symbols[offset + 1];
					final String i = (String) _symbol_i.value;
					return new Var(i);
			}
			case 27: // expression = expression.e DOT IDCON.i
			{
					final Symbol _symbol_e = _symbols[offset + 1];
					final Cons e = (Cons) _symbol_e.value;
					final Symbol _symbol_i = _symbols[offset + 3];
					final String i = (String) _symbol_i.value;
					return new Field(e,i);
			}
			case 28: // expression = expression.e PLUS simpleexpression.f
			{
					final Symbol _symbol_e = _symbols[offset + 1];
					final Cons e = (Cons) _symbol_e.value;
					final Symbol _symbol_f = _symbols[offset + 3];
					final Cons f = (Cons) _symbol_f.value;
					return new Cat(e,f);
			}
			case 30: // simpleexpression = symbolcon.s
			{
					final Symbol _symbol_s = _symbols[offset + 1];
					final Cons s = (Cons) _symbol_s.value;
					return new Sym(s);
			}
			case 31: // simpleexpression = NATCON.n
			{
					final Symbol _symbol_n = _symbols[offset + 1];
					final String n = (String) _symbol_n.value;
					return new Num(n);
			}
			case 32: // simpleexpression = textexpression.t
			{
					final Symbol _symbol_t = _symbols[offset + 1];
					final Cons t = (Cons) _symbol_t.value;
					return new Text(t);
			}
			case 33: // simpleexpression = LBRACK expressions.e RBRACK
			{
					final Symbol _symbol_e = _symbols[offset + 2];
					final ArrayList e = (ArrayList) _symbol_e.value;
					return new List(e);
			}
			case 34: // simpleexpression = LBRACE keyvaluepairs.party RBRACE
			{
					final Symbol _symbol_party = _symbols[offset + 2];
					final ArrayList party = (ArrayList) _symbol_party.value;
					return new Record(party);
			}
			case 35: // textexpression = TEXT.t
			{
					final Symbol _symbol_t = _symbols[offset + 1];
					final String t = (String) _symbol_t.value;
					return new Text_expression(t);
			}
			case 36: // symbolcon = SYMBOLCON.s
			{
					final Symbol _symbol_s = _symbols[offset + 1];
					final String s = (String) _symbol_s.value;
					return new Sym_text(s);
			}
			case 37: // expressions = expression
			{
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
			}
			case 38: // expressions = expressions COMMA expression
			{
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 3]); return _symbols[offset + 1];
			}
			case 39: // keyvaluepairs = keyvaluepair
			{
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
			}
			case 40: // keyvaluepairs = keyvaluepairs COMMA keyvaluepair
			{
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 3]); return _symbols[offset + 1];
			}
			case 41: // keyvaluepair = IDCON.i COLON expression.e
			{
					final Symbol _symbol_i = _symbols[offset + 1];
					final String i = (String) _symbol_i.value;
					final Symbol _symbol_e = _symbols[offset + 3];
					final Cons e = (Cons) _symbol_e.value;
					return new Pair(i,e);
			}
			case 42: // texttail = MIDTEXT.m embed.e texttail.t
			{
					final Symbol _symbol_m = _symbols[offset + 1];
					final String m = (String) _symbol_m.value;
					final Symbol _symbol_e = _symbols[offset + 2];
					final Cons e = (Cons) _symbol_e.value;
					final Symbol _symbol_t = _symbols[offset + 3];
					final Cons t = (Cons) _symbol_t.value;
					return new Mid(m,e,t);
			}
			case 43: // texttail = POSTTEXT.p
			{
					final Symbol _symbol_p = _symbols[offset + 1];
					final String p = (String) _symbol_p.value;
					return new Post(p);
			}
			case 44: // embedding = PRETEXT.p embed.e texttail.t
			{
					final Symbol _symbol_p = _symbols[offset + 1];
					final String p = (String) _symbol_p.value;
					final Symbol _symbol_e = _symbols[offset + 2];
					final Cons e = (Cons) _symbol_e.value;
					final Symbol _symbol_t = _symbols[offset + 3];
					final Cons t = (Cons) _symbol_t.value;
					return new Pre(p,e,t);
			}
			case 45: // lst$markup = markup
			{
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
			}
			case 46: // lst$markup = lst$markup markup
			{
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2]); return _symbols[offset + 1];
			}
			case 47: // embed = lst$markup.m expression.e
			{
					final Symbol _symbol_m = _symbols[offset + 1];
					final ArrayList m = (ArrayList) _symbol_m.value;
					final Symbol _symbol_e = _symbols[offset + 2];
					final Cons e = (Cons) _symbol_e.value;
					return new Exp_embedding(m,e);
			}
			case 49: // lst$argumentlist = argumentlist
			{
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
			}
			case 50: // lst$argumentlist = lst$argumentlist argumentlist
			{
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2]); return _symbols[offset + 1];
			}
			case 53: // arguments = LPAREN opt$lst$argumentlist.a RPAREN
			{
					final Symbol _symbol_a = _symbols[offset + 2];
					final ArrayList a = (ArrayList) _symbol_a.value;
					return new Args(a);
			}
			case 56: // argument = IDCON.i EQ expression.e
			{
					final Symbol _symbol_i = _symbols[offset + 1];
					final String i = (String) _symbol_i.value;
					final Symbol _symbol_e = _symbols[offset + 3];
					final Cons e = (Cons) _symbol_e.value;
					return new Attr(i,e);
			}
			case 58: // markupWithArguments = designator.d arguments.a
			{
					final Symbol _symbol_d = _symbols[offset + 1];
					final Cons d = (Cons) _symbol_d.value;
					final Symbol _symbol_a = _symbols[offset + 2];
					final Cons a = (Cons) _symbol_a.value;
					return new Call(d,a);
			}
			case 61: // lst$attribute = attribute
			{
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
			}
			case 62: // lst$attribute = lst$attribute attribute
			{
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2]); return _symbols[offset + 1];
			}
			case 65: // designator = IDCON.i opt$lst$attribute.a
			{
					final Symbol _symbol_i = _symbols[offset + 1];
					final String i = (String) _symbol_i.value;
					final Symbol _symbol_a = _symbols[offset + 2];
					final ArrayList a = (ArrayList) _symbol_a.value;
					return new Tag(i,a);
			}
			case 95: // StatementIf = IF LPAREN predicate.p RPAREN statement.a
			{
					final Symbol _symbol_p = _symbols[offset + 3];
					final Cons p = (Cons) _symbol_p.value;
					final Symbol _symbol_a = _symbols[offset + 5];
					final Cons a = (Cons) _symbol_a.value;
					return new If(p,a);
			}
			case 96: // StatementIfElse = IF LPAREN predicate.p RPAREN StatementNoShortIf.a ELSE statement.b
			{
					final Symbol _symbol_p = _symbols[offset + 3];
					final Cons p = (Cons) _symbol_p.value;
					final Symbol _symbol_a = _symbols[offset + 5];
					final Cons a = (Cons) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 7];
					final Cons b = (Cons) _symbol_b.value;
					return new If_else(p,a,b);
			}
			case 99: // lst$assignment = assignment
			{
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
			}
			case 100: // lst$assignment = lst$assignment assignment
			{
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2]); return _symbols[offset + 1];
			}
			case 101: // StatementLet = LET lst$assignment.a IN opt$lst$statement.s END
			{
					final Symbol _symbol_a = _symbols[offset + 2];
					final ArrayList a = (ArrayList) _symbol_a.value;
					final Symbol _symbol_s = _symbols[offset + 4];
					final ArrayList s = (ArrayList) _symbol_s.value;
					return new Let(a,s);
			}
			case 102: // StatementBlock = LBRACE opt$lst$statement.s RBRACE
			{
					final Symbol _symbol_s = _symbols[offset + 2];
					final ArrayList s = (ArrayList) _symbol_s.value;
					return new Block(s);
			}
			case 103: // StatementComment = COMMENT STRCON.s SEMICOLON
			{
					final Symbol _symbol_s = _symbols[offset + 2];
					final String s = (String) _symbol_s.value;
					return new Comment(s);
			}
			case 104: // StatementEchoExpression = ECHO expression.e SEMICOLON
			{
					final Symbol _symbol_e = _symbols[offset + 2];
					final Cons e = (Cons) _symbol_e.value;
					return new Echo(e);
			}
			case 105: // StatementEchoEmbedding = ECHO embedding.e SEMICOLON
			{
					final Symbol _symbol_e = _symbols[offset + 2];
					final Cons e = (Cons) _symbol_e.value;
					return new Echo_embedding(e);
			}
			case 106: // StatementCData = CDATA expression.e SEMICOLON
			{
					final Symbol _symbol_e = _symbols[offset + 2];
					final Cons e = (Cons) _symbol_e.value;
					return new Cdata(e);
			}
			case 107: // StatementYield = YIELD SEMICOLON
			{
					return new Yield();
			}
			case 108: // StatementMarkup = markup.m SEMICOLON
			{
					final Symbol _symbol_m = _symbols[offset + 1];
					final Cons m = (Cons) _symbol_m.value;
					return new Markup(m);
			}
			case 109: // StatementMarkup = lst$markup.s markupWithArguments.m SEMICOLON
			{
					final Symbol _symbol_s = _symbols[offset + 1];
					final ArrayList s = (ArrayList) _symbol_s.value;
					final Symbol _symbol_m = _symbols[offset + 2];
					final Cons m = (Cons) _symbol_m.value;
					return new Markup_markup(s,m);
			}
			case 110: // StatementMarkup = lst$markup.s expression.e SEMICOLON
			{
					final Symbol _symbol_s = _symbols[offset + 1];
					final ArrayList s = (ArrayList) _symbol_s.value;
					final Symbol _symbol_e = _symbols[offset + 2];
					final Cons e = (Cons) _symbol_e.value;
					return new Markup_exp(s,e);
			}
			case 111: // StatementMarkup = lst$markup.s embedding.e SEMICOLON
			{
					final Symbol _symbol_s = _symbols[offset + 1];
					final ArrayList s = (ArrayList) _symbol_s.value;
					final Symbol _symbol_e = _symbols[offset + 2];
					final Cons e = (Cons) _symbol_e.value;
					return new Markup_embedding(s,e);
			}
			case 112: // StatementMarkupStatement = lst$markup.m StatementWithoutMarkup.s
			{
					final Symbol _symbol_m = _symbols[offset + 1];
					final ArrayList m = (ArrayList) _symbol_m.value;
					final Symbol _symbol_s = _symbols[offset + 2];
					final Cons s = (Cons) _symbol_s.value;
					return new Markup_stat(m,s);
			}
			case 113: // StatementMarkupStatementNoShortIf = lst$markup.m StatementWithoutMarkupNoShortIf.s
			{
					final Symbol _symbol_m = _symbols[offset + 1];
					final ArrayList m = (ArrayList) _symbol_m.value;
					final Symbol _symbol_s = _symbols[offset + 2];
					final Cons s = (Cons) _symbol_s.value;
					return new Markup_stat(m,s);
			}
			case 114: // attribute = HASH IDCON.i
			{
					final Symbol _symbol_i = _symbols[offset + 2];
					final String i = (String) _symbol_i.value;
					return new Id(i);
			}
			case 115: // attribute = DOLLAR IDCON.i
			{
					final Symbol _symbol_i = _symbols[offset + 2];
					final String i = (String) _symbol_i.value;
					return new Name(i);
			}
			case 116: // attribute = COLON IDCON.i
			{
					final Symbol _symbol_i = _symbols[offset + 2];
					final String i = (String) _symbol_i.value;
					return new Type(i);
			}
			case 117: // attribute = ADDCHAR NATCON.w MOD NATCON.h
			{
					final Symbol _symbol_w = _symbols[offset + 2];
					final String w = (String) _symbol_w.value;
					final Symbol _symbol_h = _symbols[offset + 4];
					final String h = (String) _symbol_h.value;
					return new Width_height(w,h);
			}
			case 118: // attribute = ADDCHAR NATCON.w
			{
					final Symbol _symbol_w = _symbols[offset + 2];
					final String w = (String) _symbol_w.value;
					return new Height(w);
			}
			case 119: // lst$mappings = mappings
			{
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
			}
			case 120: // lst$mappings = lst$mappings mappings
			{
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2]); return _symbols[offset + 1];
			}
			case 123: // site = SITE opt$lst$mappings.m END
			{
					final Symbol _symbol_m = _symbols[offset + 2];
					final ArrayList m = (ArrayList) _symbol_m.value;
					return new Site(m);
			}
			case 126: // mapping = path.p COLON markup.m
			{
					final Symbol _symbol_p = _symbols[offset + 1];
					final Cons p = (Cons) _symbol_p.value;
					final Symbol _symbol_m = _symbols[offset + 3];
					final Cons m = (Cons) _symbol_m.value;
					return new Mapping(p,m);
			}
			case 127: // path = DIRNAME.d DIV FILENAME.f
			{
					final Symbol _symbol_d = _symbols[offset + 1];
					final String d = (String) _symbol_d.value;
					final Symbol _symbol_f = _symbols[offset + 3];
					final String f = (String) _symbol_f.value;
					return new Path(d,f);
			}
			case 128: // path = FILENAME.f
			{
					final Symbol _symbol_f = _symbols[offset + 1];
					final String f = (String) _symbol_f.value;
					return new Filenamestring(f);
			}
			case 129: // type = LIST
			{
					return new List_type();
			}
			case 130: // type = RECORD
			{
					return new Record_type();
			}
			case 131: // type = STRING
			{
					return new String_type();
			}
			case 133: // simplepredicate = expression.e DOT type.t QUESTION
			{
					final Symbol _symbol_e = _symbols[offset + 1];
					final Cons e = (Cons) _symbol_e.value;
					final Symbol _symbol_t = _symbols[offset + 3];
					final Cons t = (Cons) _symbol_t.value;
					return new Is_a(e,t);
			}
			case 134: // simplepredicate = NOT simplepredicate.p
			{
					final Symbol _symbol_p = _symbols[offset + 2];
					final Cons p = (Cons) _symbol_p.value;
					return new Not(p);
			}
			case 135: // conjunction = predicate.p ANDAND simplepredicate.q
			{
					final Symbol _symbol_p = _symbols[offset + 1];
					final Cons p = (Cons) _symbol_p.value;
					final Symbol _symbol_q = _symbols[offset + 3];
					final Cons q = (Cons) _symbol_q.value;
					return new And(p,q);
			}
			case 138: // predicate = predicate.p OROR simplepredicate.q
			{
					final Symbol _symbol_p = _symbols[offset + 1];
					final Cons p = (Cons) _symbol_p.value;
					final Symbol _symbol_q = _symbols[offset + 3];
					final Cons q = (Cons) _symbol_q.value;
					return new Or(p,q);
			}
			case 2: // opt$lst$moduleelement = 
			case 14: // opt$lst$statement = 
			case 51: // opt$lst$argumentlist = 
			case 63: // opt$lst$attribute = 
			case 121: // opt$lst$mappings = 
			{
				return new Symbol(null);
			}
			case 3: // opt$lst$moduleelement = lst$moduleelement
			case 8: // moduleelement = functiondef
			case 9: // moduleelement = import
			case 10: // moduleelement = site
			case 15: // opt$lst$statement = lst$statement
			case 26: // expression = simpleexpression
			case 29: // simpleexpression = var
			case 48: // embed = expression.e
			case 52: // opt$lst$argumentlist = lst$argumentlist
			case 54: // argumentlist = argument
			case 57: // argument = expression
			case 59: // markup = markupWithArguments
			case 60: // markup = designator.d
			case 64: // opt$lst$attribute = lst$attribute
			case 66: // StatementWithoutSubstatement = StatementBlock
			case 67: // StatementWithoutSubstatement = StatementCData
			case 68: // StatementWithoutSubstatement = StatementYield
			case 69: // StatementWithoutSubstatement = StatementComment
			case 70: // StatementWithoutSubstatement = StatementMarkup
			case 71: // StatementWithoutSubstatement = StatementEchoExpression
			case 72: // StatementWithoutSubstatement = StatementEchoEmbedding
			case 73: // StatementWithoutSubstatement = StatementLet
			case 74: // StatementWithoutSubAndMarkup = StatementBlock
			case 75: // StatementWithoutSubAndMarkup = StatementCData
			case 76: // StatementWithoutSubAndMarkup = StatementYield
			case 77: // StatementWithoutSubAndMarkup = StatementComment
			case 78: // StatementWithoutSubAndMarkup = StatementEchoExpression
			case 79: // StatementWithoutSubAndMarkup = StatementEchoEmbedding
			case 80: // StatementWithoutSubAndMarkup = StatementLet
			case 81: // statement = StatementWithoutSubstatement
			case 82: // statement = StatementIf
			case 83: // statement = StatementIfElse
			case 84: // statement = StatementEach
			case 85: // statement = StatementMarkupStatement
			case 86: // StatementNoShortIf = StatementWithoutSubstatement
			case 87: // StatementNoShortIf = StatementEachNoShortIf
			case 88: // StatementNoShortIf = StatementMarkupStatementNoShortIf
			case 89: // StatementWithoutMarkup = StatementWithoutSubAndMarkup
			case 90: // StatementWithoutMarkup = StatementIf
			case 91: // StatementWithoutMarkup = StatementIfElse
			case 92: // StatementWithoutMarkup = StatementEach
			case 93: // StatementWithoutMarkupNoShortIf = StatementWithoutSubAndMarkup
			case 94: // StatementWithoutMarkupNoShortIf = StatementEachNoShortIf
			case 122: // opt$lst$mappings = lst$mappings
			case 124: // mappings = mapping
			case 132: // simplepredicate = expression
			case 136: // predicate = simplepredicate
			case 137: // predicate = conjunction
			{
				return _symbols[offset + 1];
			}
			case 55: // argumentlist = argument COMMA argumentlist
			case 125: // mappings = mapping SEMICOLON mappings
			{
				return _symbols[offset + 3];
			}
			case 97: // StatementEach = EACH LPAREN var COLON expression RPAREN statement
			case 98: // StatementEachNoShortIf = EACH LPAREN var COLON expression RPAREN StatementNoShortIf
			{
				return _symbols[offset + 7];
			}
			default:
				throw new IllegalArgumentException("unknown production #" + rule_num);
		}
	}
}
