B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=6.3
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: true
	#IncludeTitle: false
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
Dim s As Int
	Dim tgtlabel As Label

	Dim myarray(90) As String
	
	Dim katigo As Label
	Dim epilogi As Label
Dim searching As ImageView





	Private back1 As ImageView
	Dim clv2 As CustomListView
	
	Dim Panel2 As Panel
	Dim ili As Button
Dim ousia As Button
Dim simansi As Button
Dim pixi As Button

Dim lista As Button

	Private katigor As Button
	
	Dim fakos As Label
	
	Private mple As ImageView
	Private simanseislabel As Label
	Private listabel As Label
	Private katigorlabel As Label
	Private ousialabel As Label
	Private ililabel As Label
	



	


	

End Sub

Sub Activity_Create(FirstTime As Boolean)
Activity.LoadLayout("katigorrrr.bal")

  		   
	 simanseislabel.Top = 3%y
simanseislabel.left = 3.5%x
simanseislabel.height = 27.5%y
simanseislabel.Width  = 45%x
   simansi.Top = 3%y
simansi.left = 3%x
simansi.height = 28%y
simansi.Width  = 45%x



''PANW DEXIA MESH
lista.Top = 3%y
lista.left = 51.5%x
lista.height = 13%y
lista.Width  = 21.25%x

listabel.Top = 3%y
listabel.left = 51.75%x
listabel.height = 13%y
listabel.Width  = 21.25%x



katigor.Top = 18%y
katigor.left = 51.50%x
katigor.height = 13%y
katigor.Width  = 21.25%x

katigorlabel.Top = 18%y
katigorlabel.left = 51.75%x
katigorlabel.height = 13%y
katigorlabel.Width  = 21.25%x
'PANW DEXIA AKRH
ousia.Top = 3%y
ousia.left = 75.75%x
ousia.height = 13%y
ousia.Width  = 21.25%x
ousialabel.Top = 3%y
ousialabel.left = 76%x
ousialabel.height = 13%y
ousialabel.Width  = 21.25%x

ili.Top = 18%y
ili.left = 75.75%x
ili.height = 13%y
ili.Width  = 21.25%x
ililabel.Top = 18%y
ililabel.left = 76%x
ililabel.height = 13%y
ililabel.Width  = 21.25%x
   

mple.top = 93%y
mple.left = 3%x
mple.width = 94%x
mple.height = 7%y

   	
  


   

clv2.Initialize(Me, "clv2")
	Panel2.AddView(clv2.AsView, 0%x, 0%y,94%x ,57.5%y )
	 Panel2.Top = 33%y
  Panel2.Left = 3%x
  Panel2.Width = 94%x
  Panel2.Height = 57.5%y
	clv2.DefaultTextBackgroundColor = Colors.DarkGray
	clv2.AddTextItem("20 ασφυξιογόνο αέριο ή αέριο με κανένα δευτερεύοντα κίνδυνο" ,"")
clv2.AddTextItem("22 υγροποιημένο αέριο υπό ψύξη, ασφυξιογόνο" ,"")
clv2.AddTextItem("223 υγροποιημένο αέριο υπό ψύξη, εύφλεκτο" ,"")
clv2.AddTextItem("225 υγροποιημένο αέριο υπό ψύξη, οξειδωτικό (πυροδυναμωτικό)" ,"")
clv2.AddTextItem("23 εύφλεκτο αέριο" ,"")
clv2.AddTextItem("239 εύφλεκτο αέριο, που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση" ,"")
clv2.AddTextItem("25 οξειδωτικό αέριο (πυροδυναμωτικό)" ,"")
clv2.AddTextItem("26 τοξικό αέριο" ,"")
clv2.AddTextItem("263 τοξικό αέριο, εύφλεκτο" ,"")
clv2.AddTextItem("265 τοξικό αέριο, οξειδωτικό (πυροδυναμωτικό)" ,"")
clv2.AddTextItem("268 τοξικό αέριο, διαβρωτικό" ,"")
clv2.AddTextItem("30 εύφλεκτο υγρό (με σημείο ανάφλεξης μεταξύ 23°C και 60°C, συμπεριλαμβανομένου) ή εύφλεκτο υγρό ή στερεό σε τηγμένη μορφή με σημείο ανάφλεξης πάνω από τους 60°C, που έχει θερμανθεί σε θερμοκρασία ίση με ή πάνω από το σημείο ανάφλεξής του, ή αυτοθερμαινόμενο υγρό" ,"")
clv2.AddTextItem("323 εύφλεκτο υγρό που αντιδρά με το νερό και εκπέμπει εύφλεκτα αέρια" ,"")
clv2.AddTextItem("Χ323 εύφλεκτο υγρό που αντιδρά επικίνδυνα με το νερό, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)" ,"")
clv2.AddTextItem("33 πολύ εύφλεκτο υγρό (σημείο ανάφλεξης κάτω από 23°C)" ,"")
clv2.AddTextItem("333 πυροφορικό υγρό" ,"")
clv2.AddTextItem("Χ333 πυροφορικό υγρό (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)" ,"")
clv2.AddTextItem("336 πολύ εύφλεκτο υγρό, τοξικό" ,"")
clv2.AddTextItem("338 πολύ εύφλεκτο υγρό, διαβρωτικό" ,"")
clv2.AddTextItem("Χ338 πολύ εύφλεκτο υγρό, διαβρωτικό, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)" ,"")
clv2.AddTextItem("339 πολύ εύφλεκτο υγρό που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση" ,"")
clv2.AddTextItem("36 εύφλεκτο υγρό (σημείο ανάφλεξης μεταξύ 23ºC και 60ºC, συμπεριλαμβανομένου), ελαφρώς τοξικό, ή αυτοθερμαινόμενο υγρό, τοξικό" ,"")
clv2.AddTextItem("362 εύφλεκτο υγρό, τοξικό, που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια" ,"")
clv2.AddTextItem("Χ362 εύφλεκτο υγρό, τοξικό, που αντιδρά επικίνδυνα με το νερό, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)" ,"")
clv2.AddTextItem("368 εύφλεκτο υγρό, τοξικό, διαβρωτικό" ,"")
clv2.AddTextItem("38 εύφλεκτο υγρό (σημείο ανάφλεξης μεταξύ 23ºC και 60ºC, συμπεριλαμβανομένου), ελαφρώς διαβρωτικό ή αυτοθερμαινόμενο υγρό, διαβρωτικό" ,"")
clv2.AddTextItem("382 εύφλεκτο υγρό, διαβρωτικό, που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια" ,"")
clv2.AddTextItem("Χ382 εύφλεκτο υγρό, διαβρωτικό, που αντιδρά επικίνδυνα με το νερό, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)" ,"")
clv2.AddTextItem("39 εύφλεκτο υγρό, που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση" ,"")
clv2.AddTextItem("40 εύφλεκτο στερεό ή αυτενεργή ουσία ή αυτοθερμαινόμενη ουσία" ,"")
clv2.AddTextItem("423 στερεό που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια" ,"")
clv2.AddTextItem("Χ423 εύφλεκτο στερεό που αντιδρά επικίνδυνα με το νερό, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)" ,"")
clv2.AddTextItem("43 αυθόρμητα εύφλεκτο (αυταναφλέξιμο) στερεό" ,"")
clv2.AddTextItem("44 εύφλεκτο στερεό, σε τηγμένη μορφή σε αυξημένη θερμοκρασία" ,"")
clv2.AddTextItem("446 εύφλεκτο στερεό, τοξικό, σε τηγμένη μορφή, σε αυξημένη θερμοκρασία" ,"")
clv2.AddTextItem("46 εύφλεκτο ή αυτοθερμαινόμενο στερεό, τοξικό" ,"")
clv2.AddTextItem("462 τοξικό στερεό, που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια" ,"")
clv2.AddTextItem("Χ462 στερεό που αντιδρά επικίνδυνα με το νερό, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)" ,"")
clv2.AddTextItem("48 εύφλεκτο ή αυτοθερμαινόμενο στερεό, διαβρωτικό" ,"")
clv2.AddTextItem("482 διαβρωτικό στερεό που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια" ,"")
clv2.AddTextItem("Χ482 στερεό που αντιδρά επικίνδυνα με το νερό, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)" ,"")
clv2.AddTextItem("50 οξειδωτική (πυροδυναμωτική) ουσία" ,"")
clv2.AddTextItem("539 εύφλεκτο οργανικό υπεροξείδιο" ,"")
clv2.AddTextItem("55 έντονα οξειδωτική (πυροδυναμωτική) ουσία" ,"")
clv2.AddTextItem("556 έντονα οξειδωτική (πυροδυναμωτική) ουσία, τοξική" ,"")
clv2.AddTextItem("558 έντονα οξειδωτική (πυροδυναμωτική) ουσία, διαβρωτική" ,"")
clv2.AddTextItem("559 έντονα οξειδωτική (πυροδυναμωτική) ουσία, που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση" ,"")
clv2.AddTextItem("56 οξειδωτική ουσία (πυροδυναμωτική), τοξική" ,"")
clv2.AddTextItem("568 οξειδωτική ουσία (πυροδυναμωτική), τοξική, διαβρωτική" ,"")
clv2.AddTextItem("58 οξειδωτική ουσία (πυροδυναμωτική), διαβρωτική" ,"")
clv2.AddTextItem("59 οξειδωτική ουσία (πυροδυναμωτική) που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση" ,"")
clv2.AddTextItem("60 τοξική ή ελαφρώς τοξική ουσία" ,"")
clv2.AddTextItem("606 μολυσματική ουσία" ,"")
clv2.AddTextItem("623 τοξικό υγρό, που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια" ,"")
clv2.AddTextItem("63 τοξική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C, συμπεριλαμβανομένου)" ,"")
clv2.AddTextItem("638 τοξική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C, συμπεριλαμβανομένου), διαβρωτική" ,"")
clv2.AddTextItem("639 τοξική ουσία, εύφλεκτη (σημείο ανάφλεξης όχι μεγαλύτερο από τους 60°C) που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση" ,"")
clv2.AddTextItem("64 τοξικό στερεό, εύφλεκτο ή αυτοθερμαινόμενο" ,"")
clv2.AddTextItem("642 τοξικό στερεό, που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια" ,"")
clv2.AddTextItem("65 τοξική ουσία, οξειδωτική (πυροδυναμωτική)" ,"")
clv2.AddTextItem("66 πολύ τοξική ουσία" ,"")
clv2.AddTextItem("663 πολύ τοξική ουσία, εύφλεκτη (σημείο ανάφλεξης όχι μεγαλύτερο από τους 60°C)" ,"")
clv2.AddTextItem("664 πολύ τοξικό στερεό, εύφλεκτο ή αυτοθερμαινόμενο" ,"")
clv2.AddTextItem("665 πολύ τοξική ουσία, οξειδωτική (πυροδυναμωτική)" ,"")
clv2.AddTextItem("668 πολύ τοξική ουσία, διαβρωτική" ,"")
clv2.AddTextItem("669 πολύ τοξική ουσία που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση" ,"")
clv2.AddTextItem("68 τοξική ουσία, διαβρωτική" ,"")
clv2.AddTextItem("69 τοξική ή ελαφρώς τοξική ουσία, που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση" ,"")
clv2.AddTextItem("70 ραδιενεργό υλικό" ,"")
clv2.AddTextItem("78 ραδιενεργό υλικό, διαβρωτικό" ,"")
clv2.AddTextItem("80 διαβρωτική ή ελαφρώς διαβρωτική ουσία" ,"")
clv2.AddTextItem("Χ80 διαβρωτική ή ελαφρώς διαβρωτική ουσία, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)" ,"")
clv2.AddTextItem("823 διαβρωτικό υγρό που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια" ,"")
clv2.AddTextItem("83 διαβρωτική ή ελαφρώς διαβρωτική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C)" ,"")
clv2.AddTextItem("Χ83 διαβρωτική ή ελαφρώς διαβρωτική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C ), (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)" ,"")
clv2.AddTextItem("839 διαβρωτική ή ελαφρώς διαβρωτική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C συμπεριλαμβανομένου) που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση" ,"")
clv2.AddTextItem("Χ839 διαβρωτική ή ελαφρώς διαβρωτική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C συμπεριλαμβανομένου), που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση και (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)" ,"")
clv2.AddTextItem("84 διαβρωτικό στερεό, εύφλεκτο ή αυτοθερμαινόμενο" ,"")
clv2.AddTextItem("842 διαβρωτικό στερεό που αντιδρά με το νερό, εκπέμποντας εύφλεκτα αέρια" ,"")
clv2.AddTextItem("85 διαβρωτική ή ελαφρώς διαβρωτική ουσία, οξειδωτική (πυροδυναμωτική)" ,"")
clv2.AddTextItem("856 διαβρωτική ή ελαφρώς διαβρωτική ουσία, οξειδωτική (πυροδυναμωτική) και τοξική" ,"")
clv2.AddTextItem("86 διαβρωτική ή ελαφρώς διαβρωτική ουσία, τοξική" ,"")
clv2.AddTextItem("88 πολύ διαβρωτική ουσία" ,"")
clv2.AddTextItem("Χ88 πολύ διαβρωτική ουσία, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)" ,"")
clv2.AddTextItem("883 πολύ διαβρωτική ουσία, εύφλεκτη (σημείο ανάφλεξης μεταξύ 23°C και 60°C συμπεριλαμβανομένου)" ,"")
clv2.AddTextItem("884 πολύ διαβρωτικό στερεό, εύφλεκτο ή αυτοθερμαινόμενο" ,"")
clv2.AddTextItem("885 πολύ διαβρωτική ουσία, οξειδωτική (πυροδυναμωτική)" ,"")
clv2.AddTextItem("886 πολύ διαβρωτική ουσία, τοξική" ,"")
clv2.AddTextItem("Χ886 πολύ διαβρωτική ουσία, τοξική, (ΑΠΑΓΟΡΕΥΕΤΑΙ Η ΚΑΤΑΣΒΕΣΗ ΜΕ ΝΕΡΟ)" ,"")
clv2.AddTextItem("89 διαβρωτική ή ελαφρώς διαβρωτική ουσία, που μπορεί αυθόρμητα να οδηγήσει σε βίαιη αντίδραση" ,"")
clv2.AddTextItem("90 περιβαλλοντικά επικίνδυνη ουσία, διάφορες επικίνδυνες ουσίες" ,"")
clv2.AddTextItem("99 διάφορες επικίνδυνες ουσίες που μεταφέρονται σε αυξημένη θερμοκρασία" ,"")
	
 simanseislabel.BringToFront
	 listabel.BringToFront
	 katigorlabel.BringToFront
	 ousialabel.BringToFront
	 ililabel.BringToFront




End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
'Activity.Finish
End Sub

Sub ili_Click
	StartActivity("ilika")
	Activity.Finish
End Sub
Sub ousia_Click
	StartActivity("ousies")
	Activity.Finish
End Sub
Sub pixi_Click
	StartActivity("pixida")
	Activity.Finish
End Sub

Sub lista_Click
	StartActivity("listaousies")
	Activity.Finish
End Sub

Sub katigor_Click
	StartActivity("simanseis")
	Activity.Finish
End Sub
Sub gpss_Click
	
StartActivity("gpssingal")
	Activity.Finish
End Sub

Sub simanseislabel_Click
	StartActivity("Main")
	Activity.Finish
End Sub
Sub listabel_Click
	StartActivity("listaousies")
	Activity.Finish
End Sub
Sub katigorlabel_Click
	StartActivity("simanseis")
	Activity.Finish
End Sub
Sub ousialabel_Click
	StartActivity("ousies")
	Activity.Finish
End Sub
Sub ililabel_Click
	StartActivity("ilika")
	Activity.Finish
End Sub
Sub simansi_Click
	StartActivity("Main")
	Activity.Finish
End Sub
Sub Activity_KeyPress (KeyCode As Int) As Boolean
    If KeyCode = KeyCodes.KEYCODE_BACK Then
      
             Activity.Finish
       End If
End Sub
