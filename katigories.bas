Type=Activity
Version=3.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
Dim s As Int
	Dim tgtlabel As Label
	Dim tgtspin As Spinner
	Dim myarray(90) As String
	'Dim imageviewspin As ImageView
	Dim katigories As Label
	Dim epilogi As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("katigories")
myarray(0)="Κατηγορία"
 myarray(1)="20"
 myarray(2)="22"
 myarray(3)="223"  
 myarray(4)="225" 
 myarray(5)="23" 
 myarray(6)="239" 
 myarray(7)="25" 
 myarray(8)="26" 
 myarray(9)="263" 
 myarray(10)="268" 
 myarray(11)="30" 
 myarray(12)="323"
 myarray(13)="Χ323"
 myarray(14)="33"
 myarray(15)="333"  
 myarray(16)="Χ333"
  myarray(17)="336" 
 myarray(18)="Χ338" 	 
 myarray(19)="339" 
 myarray(20)="362" 
 myarray(21)="Χ362" 
  myarray(22)="36" 
  myarray(23)="368" 
 myarray(24)="38" 
 myarray(25)="382"
 myarray(26)="Χ382"
 myarray(27)="39"
 myarray(28)="40"
 myarray(29)="Χ423"  	
 myarray(30)="43" 
 myarray(31)="44" 
 myarray(32)="446"
 myarray(33)="46" 
 myarray(34)="462" 
 myarray(35)="Χ462" 
 myarray(36)="48" 
 myarray(37)="482" 
 myarray(38)="Χ482" 
 myarray(39)="50"
 myarray(40)="539"
 myarray(41)="55"  
 myarray(42)="556" 
 myarray(43)="558" 
 myarray(44)="559" 
 myarray(45)="56" 
 myarray(46)="568" 
 myarray(47)="58" 
 myarray(48)="59" 
  myarray(49)="60" 
 myarray(50)="606"
 myarray(51)="623"
 myarray(52)="63"
 myarray(53)="638"
 myarray(54)="639"  
 myarray(55)="64" 
 myarray(56)="642" 
 myarray(57)="65" 
 
  myarray(58)="66"  
 myarray(59)="663" 
 myarray(60)="664" 
 myarray(61)="665" 
 myarray(62)="668" 
 myarray(63)="669"
 myarray(64)="68"
 myarray(65)="69"
 myarray(66)="70"  
 myarray(67)="78" 
 myarray(68)="80" 
 myarray(69)="Χ80" 
 myarray(70)="823" 
 myarray(71)="83" 
 myarray(72)="Χ83" 
 myarray(73)="839" 
 myarray(74)="Χ839"
 myarray(75)="84"
 myarray(76)="842"
 myarray(77)="85"
 myarray(78)="856"  
 myarray(79)="86" 
 myarray(80)="88" 
 myarray(81)="883" 
 myarray(82)="884" 
 myarray(83)="885" 
 myarray(84)="886" 
 myarray(85)="Χ88"
 myarray(86)="Χ886" 
 myarray(87)="89" 
 myarray(88)="90"
 myarray(89)="99"


  		   

   	
  


 tgtspin.Initialize("spin")
 tgtspin.Prompt="Κατηγορία"
 tgtspin.AddAll(myarray)
    tgtspin.TextColor = Colors.Black
tgtspin.Color = Colors.White
  Activity.AddView(tgtspin,40%x,0%y,60%x,11%y)
katigories.Top = 10%y
katigories.Left = 5%x
katigories.Height = 20%y
katigories.Width = 90%x
  ' imageviewspin.top = 11%y
  'imageviewspin.left = 0%x
  'imageviewspin.height = 15%y
  'imageviewspin.width = 100%x
  katigories.textcolor = Colors.black
tgtspin.TextSize = 18

	katigories.TextSize = 18
	epilogi.Top = 0%y
epilogi.Left = 5%x
epilogi.Height = 11%y
epilogi.Width = 35%x
epilogi.TextSize = 18
	epilogi.textcolor = Colors.black
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub spin_ItemClick (Position As Int, Value As Object)
tgtlabel.text = Value
  If tgtlabel.Text ="20" Then
katigories.text = "ασφυξιογόνο αέριο ή αέριο με κανένα δευτερεύοντα κίνδυνο"
End If

 If tgtlabel.Text ="22" Then
katigories.text = "υγροποιημένο αέριο υπό ψύξη, ασφυξιογόνο"
End If

 If tgtlabel.Text ="223"  Then
katigories.text = "υγροποιημένο αέριο υπό ψύξη, εύφλεκτο	   "
End If
 
 If tgtlabel.Text ="225"  Then
katigories.text = "υγροποιημένο αέριο υπό ψύξη, οξειδωτικό (πυροδυναμωτικό)"
End If
If tgtlabel.Text ="X333" Then
katigories.text = "	πυροφορικό υγρό που αντιδρά επικίνδυνα με το νερό (απαγορεύται η χρήση νερού)"
End If


If tgtlabel.Text ="36" Then
katigories.text = "	εύφλεκτο υγρό (σημείο ανάφλεξης μεταξύ 23?C και 60?C, συμπεριλαμβανομένου), ελαφρώς τοξικό, ή αυτοθερμαινόμενο υγρό, τοξικο)"
End If


If tgtlabel.Text ="446" Then
katigories.text = "εύφλεκτο στερεό, τοξικό, σε τηγμένη μορφή, σε αυξημένη θερμοκρασία	"
End If


If tgtlabel.Text ="60" Then
katigories.text = "τοξική ή ελαφρώς τοξική ουσία"
End If

If tgtlabel.Text ="66" Then
katigories.text = "πολύ τοξική ουσία"
End If

If tgtlabel.Text ="663" Then
katigories.text = "πολύ τοξική ουσία, εύφλεκτη (σημείο ανάφλεξης όχι μεγαλύτερο από τους 60°C)	"
End If

If tgtlabel.Text ="664" Then
katigories.text = "πολύ τοξικό στερεό, εύφλεκτο ή αυτοθερμαινόμενο"
End If

If tgtlabel.Text ="665" Then
katigories.text = "πολύ τοξική ουσία, οξειδωτική (πυροδυναμωτική)"
End If


	   

 If tgtlabel.Text ="23"  Then
katigories.text = "εύφλεκτο αέριο"
End If

 If tgtlabel.Text ="239"  Then
katigories.text = "εύφλεκτο αέριο, που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση"
End If

 If tgtlabel.Text ="25"  Then
katigories.text = "οξειδωτικό αέριο (πυροδυναμωτικό)"
End If

 If tgtlabel.Text ="26"  Then
katigories.text = "τοξικό αέριο"
End If

 If tgtlabel.Text ="263"  Then
katigories.text = "τοξικό αέριο, εύφλεκτο"
End If
If tgtlabel.Text ="265"  Then
katigories.text = "τοξικό αέριο, οξειδωτικό (πυροδυναμωτικό)"
End If
 If tgtlabel.Text ="265-268"  Then
katigories.text = "τοξικό αέριο, διαβρωτικό(265 + πυροδυναμωτικό)"
End If

 If tgtlabel.Text ="30"  Then
katigories.text = "εύφλεκτο υγρό (με σημείο ανάφλεξης μεταξύ 23°C και 60°C, συμπεριλαμβανομένου) ή εύφλεκτο υγρό ή στερεό σε τηγμένη μορφή με σημείο ανάφλεξης πάνω από τους 60°C, που έχει θερμανθεί σε θερμοκρασία ίση με ή πάνω από το σημείο ανάφλεξής του, ή αυτοθερμαινόμενο υγρό   "
End If

 If tgtlabel.Text ="323" Then
katigories.text = "εύφλεκτο υγρό που αντιδρά με το νερό και εκπέμπει εύφλεκτα αέρια"
End If

 If tgtlabel.Text ="Χ323" Then
katigories.text = "εύφλεκτο υγρό που αντιδρά επικίνδυνα με το νερό, εκπέμποντας εύφλεκτα αέρια (απαγορεύται η χρήση νερού)	   "
End If

 If tgtlabel.Text ="33" Then
katigories.text = "πολύ εύφλεκτο υγρό (σημείο ανάφλεξης κάτω από 23°C)"
End If

 If tgtlabel.Text ="333"   Then
katigories.text = "πυροφορικό υγρό"
End If

 If tgtlabel.Text ="336" Then
katigories.text = "πολύ εύφλεκτο υγρό, τοξικό	   "
End If

 If tgtlabel.Text ="338" Then
katigories.text = "πολύ εύφλεκτο υγρό, διαβρωτικό	"
End If
If tgtlabel.Text ="X338" Then
katigories.text = "πολύ εύφλεκτο υγρό, διαβρωτικό, που αντιδρά επικίνδυνα με το νερό (απαγορεύται η χρήση νερού)"
End If

 If tgtlabel.Text ="339" Then
katigories.text = "πολύ εύφλεκτο υγρό που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση"
End If

 If tgtlabel.Text ="362" Then
katigories.text = "εύφλεκτο υγρό, τοξικό, που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια"
End If

 If tgtlabel.Text ="Χ362" Then
katigories.text = "εύφλεκτο υγρό, τοξικό, που αντιδρά επικίνδυνα με το νερό, εκπέμποντας εύφλεκτα αέρια (απαγορεύται η χρήση νερού)	   "
End If

 If tgtlabel.Text ="368" Then
katigories.text = "εύφλεκτο υγρό, τοξικό, διαβρωτικό"
End If

 If tgtlabel.Text ="38" Then
katigories.text = "εύφλεκτο υγρό (σημείο ανάφλεξης μεταξύ 23ºC και 60ºC, συμπεριλαμβανομένου), ελαφρώς διαβρωτικό ή αυτοθερμαινόμενο υγρό, διαβρωτικό	"
End If

 If tgtlabel.Text ="382" Then
katigories.text = "εύφλεκτο υγρό, διαβρωτικό, που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια 	   "
End If
 If tgtlabel.Text ="Χ382" Then
katigories.text = "εύφλεκτο υγρό, διαβρωτικό, που αντιδρά επικίνδυνα με το νερό, εκπέμποντας εύφλεκτα αέρια (απαγορεύται η χρήση νερού)	"

End If

 If tgtlabel.Text ="39" Then
katigories.text = "εύφλεκτο υγρό, που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση"
End If

 If tgtlabel.Text ="40" Then
katigories.text = "εύφλεκτο στερεό ή αυτενεργή ουσία ή αυτοθερμαινόμενη ουσία	"
End If

 If tgtlabel.Text ="423"  Then
katigories.text = "στερεό που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια	"
End If
If tgtlabel.Text ="X423"  Then
katigories.text = "εύφλεκτο στερεό που αντιδρά επικίνδυνα με το νερό, εκπέμποντας εύφλεκτα αέρια (απαγορεύται η χρήση νερού)"
End If

 If tgtlabel.Text ="43" Then
katigories.text = "αυθόρμητα εύφλεκτο (αυταναφλέξιμο) στερεό "
End If

 If tgtlabel.Text ="44" Then
katigories.text = "εύφλεκτο στερεό, σε τηγμένη μορφή σε αυξημένη θερμοκρασία	   "
End If

 If tgtlabel.Text ="46" Then
katigories.text = "εύφλεκτο ή αυτοθερμαινόμενο στερεό, τοξικό"
End If

 If tgtlabel.Text ="462" Then
katigories.text = "τοξικό στερεό, που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια"
End If

 If tgtlabel.Text ="Χ462" Then
katigories.text = "στερεό που αντιδρά επικίνδυνα με το νερό, εκπέμποντας τοξικά αέρια (απαγορεύται η χρήση νερού)"
End If

 If tgtlabel.Text ="48" Then
katigories.text = "εύφλεκτο ή αυτοθερμαινόμενο στερεό, διαβρωτικό"
End If

 If tgtlabel.Text ="482" Then
katigories.text = "διαβρωτικό στερεό που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια	   "
End If

 If tgtlabel.Text ="Χ482" Then
katigories.text = "στερεό που αντιδρά επικίνδυνα με το νερό, εκπέμποντας διαβρωτικά αέρια (απαγορεύται η χρήση νερού)	"
End If

 If tgtlabel.Text ="50" Then
katigories.text = "οξειδωτική (πυροδυναμωτική) ουσία"
End If

 If tgtlabel.Text ="539" Then
katigories.text = "εύφλεκτο οργανικό υπεροξείδιο"
End If

 If tgtlabel.Text ="55"  Then
katigories.text = "έντονα οξειδωτική (πυροδυναμωτική) ουσία "
End If

 If tgtlabel.Text ="556" Then
katigories.text = "έντονα οξειδωτική (πυροδυναμωτική) ουσία, τοξική	   "
End If

 If tgtlabel.Text = "558" Then
katigories.text = "έντονα οξειδωτική (πυροδυναμωτική) ουσία, διαβρωτική"
End If

 If tgtlabel.Text ="559" Then
katigories.text = "έντονα οξειδωτική (πυροδυναμωτική) ουσία, που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση 	   "
End If

 If tgtlabel.Text ="56" Then
katigories.text = "οξειδωτική ουσία (πυροδυναμωτική), τοξική"
End If

 If tgtlabel.Text ="568" Then
katigories.text = "οξειδωτική ουσία (πυροδυναμωτική), τοξική, διαβρωτική"
End If

 If tgtlabel.Text ="58" Then
katigories.text = "οξειδωτική ουσία (πυροδυναμωτική), διαβρωτική	"
End If

 If tgtlabel.Text ="59" Then
katigories.text = "οξειδωτική ουσία (πυροδυναμωτική) που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση"
End If

 If tgtlabel.Text ="606" Then
katigories.text = "μολυσματική ουσία"
End If

 If tgtlabel.Text ="623" Then
katigories.text = "τοξικό υγρό, που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια 	"
End If
 If tgtlabel.Text ="63" Then
katigories.text = "τοξική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C)	   "
End If

 If tgtlabel.Text ="638" Then
katigories.text = "τοξική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C,διαβρωτική	"
End If

 If tgtlabel.Text ="639"  Then
katigories.text = "τοξική ουσία, εύφλεκτη (σημείο ανάφλεξης όχι μεγαλύτερο από τους 60°C) που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση"
End If

 If tgtlabel.Text ="64" Then
katigories.text = "τοξικό στερεό, εύφλεκτο ή αυτοθερμαινόμενο"
End If

 If tgtlabel.Text ="642" Then
katigories.text = "τοξικό στερεό, που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια"
End If

 If tgtlabel.Text ="65" Then
katigories.text = "τοξική ουσία, οξειδωτική (πυροδυναμωτική)	"
End If

 If tgtlabel.Text ="668" Then
katigories.text = "πολύ τοξική ουσία, διαβρωτική	   "
End If

 If tgtlabel.Text ="669" Then
katigories.text = "πολύ τοξική ουσία που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση	   "
End If

 If tgtlabel.Text ="68" Then
katigories.text = "τοξική ουσία, διαβρωτική"
End If

 If tgtlabel.Text ="69" Then
katigories.text = "τοξική ή ελαφρώς τοξική ουσία, που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση"
End If

 If tgtlabel.Text ="70"  Then
katigories.text = "ραδιενεργό υλικό"
End If

 If tgtlabel.Text ="78" Then
katigories.text = "ραδιενεργό υλικό, διαβρωτικό	"
End If

 If tgtlabel.Text ="80" Then
katigories.text = "διαβρωτική ή ελαφρώς διαβρωτική ουσία	   "
End If

 If tgtlabel.Text ="Χ80" Then
katigories.text = "διαβρωτική ή ελαφρώς διαβρωτική ουσία, που αντιδρά επικίνδυνα με το νερό 	"
End If

 If tgtlabel.Text ="823" Then
katigories.text = "διαβρωτικό υγρό που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια"
End If

 If tgtlabel.Text ="83" Then
katigories.text = "διαβρωτική ή ελαφρώς διαβρωτική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C)"
End If

 If tgtlabel.Text ="Χ83" Then
katigories.text = "διαβρωτική ή ελαφρώς διαβρωτική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C ), που αντιδρά επικίνδυνα με το νερό (απαγορεύται η χρήση νερού)"
End If

 If tgtlabel.Text ="839" Then
katigories.text = "διαβρωτική ή ελαφρώς διαβρωτική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C συμπεριλαμβανομένου) που μπορεί  αυθόρμητα να οδηγήσει σε βίαιη αντίδραση	"
End If

 If tgtlabel.Text ="Χ839" Then
katigories.text = "διαβρωτική ή ελαφρώς διαβρωτική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C συμπεριλαμβανομένου), που μπορεί  αυθόρμητα να οδηγήσει σε βίαιη αντίδραση και που αντιδρά επικίνδυνα με το νερό (απαγορεύται η χρήση νερού)	"
End If

 If tgtlabel.Text ="84" Then
katigories.text = "διαβρωτικό στερεό, εύφλεκτο ή αυτοθερμαινόμενο"
End If

 If tgtlabel.Text ="842" Then
katigories.text = "διαβρωτικό στερεό που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια"
End If

 If tgtlabel.Text ="85" Then
katigories.text = "διαβρωτική ή ελαφρώς διαβρωτική ουσία, οξειδωτική (πυροδυναμωτική)"
End If

 If tgtlabel.Text ="856"  Then
katigories.text = "διαβρωτική ή ελαφρώς διαβρωτική ουσία, οξειδωτική (πυροδυναμωτική) και τοξική	   "
End If

 If tgtlabel.Text ="86" Then
katigories.text = "διαβρωτική ή ελαφρώς διαβρωτική ουσία,  τοξική	"
End If

 If tgtlabel.Text ="88" Then
katigories.text = "πολύ διαβρωτική ουσία	"
End If

 If tgtlabel.Text ="883" Then
katigories.text = "πολύ διαβρωτική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C"
End If

 If tgtlabel.Text ="884" Then
katigories.text = "πολύ διαβρωτικό στερεό, εύφλεκτο ή αυτοθερμαινόμεν"
End If

 If tgtlabel.Text ="885" Then
katigories.text = "πολύ διαβρωτική ουσία, οξειδωτική (πυροδυναμωτική)"
End If

 If tgtlabel.Text ="886" Then
katigories.text = "πολύ διαβρωτική ουσία, τοξική"
End If

 If tgtlabel.Text ="Χ886" Then
katigories.text = "πολύ διαβρωτική ουσία, τοξική, που αντιδρά επικίνδυνα με το νερό (απαγορεύται η χρήση νερού)	   "
End If

 If tgtlabel.Text ="89" Then
katigories.text = "διαβρωτική ή ελαφρώς διαβρωτική ουσία, που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση	"
End If

 If tgtlabel.Text ="90" Then
katigories.text = "περιβαλλοντικά επικίνδυνη ουσία, διάφορες επικίνδυνες ουσίες"
End If

 If tgtlabel.Text ="99" Then
katigories.text = "διάφορες επικίνδυνες ουσίες που μεταφέρονται σε αυξημένη θερμοκρασία	 "
End If
 If tgtlabel.Text ="Χ88" Then
katigories.text = "πολύ διαβρωτική ουσία, που αντιδρά επικίνδυνα με το νερό (απαγορεύται η χρήση νερού)	 "
End If

katigories.text = Value

minima
End Sub
Sub minima
Msgbox(katigories.text,"") 
End Sub