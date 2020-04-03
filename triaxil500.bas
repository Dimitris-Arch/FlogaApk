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
Dim sc As ScrollView
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



	Dim Panel As Panel

	Dim clv2 As CustomListView
	
	Dim Panel2 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("adr.bal")
    

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

 
clv2.AddTextItem("3401	Κατηγορία 4.3	Αλκαλίων και αμάλγαμα , στερεά	" ,"")   
clv2.AddTextItem("3402	Κατηγορία 4.3	Αλκαλικών γαιών αμάλγαμα , στερεά	   " ,"")
clv2.AddTextItem("3403	Κατηγορία 4.3	Μεταλλικό κάλιο κράματα , στερεά	   " ,"")
clv2.AddTextItem("3404	Κατηγορία 4.3	Κάλιο νάτριο κράματα , στερεά	 " ,"")
clv2.AddTextItem("3405	Κατηγορία 5.1	Βάριο χλωρικό λύση	   " ,"")
clv2.AddTextItem("3406	Κατηγορία 5.1	Βάριο υπερχλωρικό λύση	   " ,"")
clv2.AddTextItem("3407	Κατηγορία 5.1	Χλωρικό άλας και χλωριούχο μαγνήσιο μίγμα διαλύματος	" ,"")   
clv2.AddTextItem("3408	Κατηγορία 5.1	Μόλυβδος υπερχλωρικό λύση	   " ,"")
clv2.AddTextItem("3409	Κατηγορία 6.1	Chloronitrobenzenes , υγρό	   " ,"")
clv2.AddTextItem("3410	Κατηγορία 6.1	Χλωρο-ο-τολουϊδίνης διάλυμα υδροχλωρικής	" ,"")   
clv2.AddTextItem("3411	Κατηγορία 6.1	Bήτα-ναφθιλαμίνη " ,"")
clv2.AddTextItem("3412	Κατηγορία 8	Μυρμηκικό οξύ	   " ,"")
clv2.AddTextItem("3413	Κατηγορία 6.1	Κυανιούχο κάλιο" ,"")	   
clv2.AddTextItem("3414	Κατηγορία 6.1	Κυανιούχο νάτριο" ,"")	   
clv2.AddTextItem("3415	Κατηγορία 6.1	Φθοριούχο νάτριο " ,"")   
clv2.AddTextItem("3416	Κατηγορία 6.1	Χλωροακετοφαινόνης,υγρόΒρωμιούχο " ,"")
clv2.AddTextItem("3418	Κατηγορία 6.1	Τολουυλενοδιαμίνη  " ,"")
clv2.AddTextItem("3419	Κατηγορία 8	Βόριο τριφθοριούχο - οξικό οξύ συγκρότημα, στερεά	   " ,"")
clv2.AddTextItem("3420	Κατηγορία 8	Βόριο τριφθοριούχο - προπιονικό οξύ συγκρότημα, στερεά	   " ,"")
clv2.AddTextItem("3421	Κατηγορία 8	Κάλιο διφθοριούχο υδρογόνου" ,"")	   
clv2.AddTextItem("3422	Κατηγορία 6.1	Φθοριούχο κάλιο διάλυμα	" ,"")   
clv2.AddTextItem("3423	Κατηγορία 8	Υδροξείδιο τετραμεθυλαμμωνίου , στερεά	   " ,"")
clv2.AddTextItem("3424	Κατηγορία 6.1	Αμμώνιο δινιτρο-ο-κρεζολικό " ,"")  
clv2.AddTextItem("3425	Κατηγορία 8	Βρωμοξεικόοξύ , στερεά	" ,"")   
clv2.AddTextItem("3426	Κατηγορία 6.1	Το ακρυλαμίδιο " ,"")   
clv2.AddTextItem("3427	Κατηγορία 6.1	Χλωροβενζυλ χλωριούχα , στερεά	" ,"")   
clv2.AddTextItem("3428	Κατηγορία 6.1	Χλωρομεθυλοφαινυλο ισοκυανικό , στερεά	" ,"")   
clv2.AddTextItem("3429	Κατηγορία 6.1	Chlorotoluidines , υγρό	   " ,"")
clv2.AddTextItem("3430	Κατηγορία 6.1	Ξυλενόλες , υγρό	   " ,"")
clv2.AddTextItem("3431	Κατηγορία 6.1	Nitrobenzotrifluorides , στερεά	   " ,"")
clv2.AddTextItem("3432	Κατηγορία 9	Τα πολυχλωριωμένα διφαινύλια , στερεά	   " ,"")	   
clv2.AddTextItem("3434	Κατηγορία 6.1	Νιτροκρεσόλες , υγρό	   " ,"")
clv2.AddTextItem("3436	Κατηγορία 6.1	Ένυδρο εξαφθοροακετόνης , στερεά	 " ,"")  
clv2.AddTextItem("3437	Κατηγορία 6.1	Chlorocresols , στερεά	   " ,"")
clv2.AddTextItem("3438	Κατηγορία 6.1	άλφα-μεθυλβενζύλ αλκοόλ , στερεά	" ,"")   
clv2.AddTextItem("3439	Κατηγορία 6.1	Νιτρίλια , τοξικά, στερεά, 	   " ,"")
clv2.AddTextItem("3440	Κατηγορία 6.1	Σελήνιο ένωση, υγρό, 	   " ,"")
clv2.AddTextItem("3441	Κατηγορία 6.1	Chlorodinitrobenzenes , στερεά	" ,"")   
clv2.AddTextItem("3442	Κατηγορία 6.1	Dichloroanilines , στερεά	   " ,"")
clv2.AddTextItem("3443	Κατηγορία 6.1	Dinitrobenzenes , στερεά	   " ,"")
clv2.AddTextItem("3444	Κατηγορία 6.1	Η νικοτίνη υδροχλωρική, στερεά	   " ,"")
clv2.AddTextItem("3445	Κατηγορία 6.1	Η νικοτίνη θειικό άλας, στερεό	   " ,"")
clv2.AddTextItem("3446	Κατηγορία 6.1	Νιτροτολουόλια , στερεά	   " ,"")
clv2.AddTextItem("3447	Κατηγορία 6.1	Nitroxylenes , στερεά	   " ,"")
clv2.AddTextItem("3448	Κατηγορία 6.1	Δακρυγόνα ουσία, στερεά, 	   " ,"")
clv2.AddTextItem("3449	Κατηγορία 6.1	Βρωμοβενζυλο κυανιούχα , στερεά	   " ,"")
clv2.AddTextItem("3450	Κατηγορία 6.1	Diphenylchloroarsine , στερεά	   " ,"")
clv2.AddTextItem("3451	Κατηγορία 6.1	Τολουϊδίνες , στερεά	   " ,"")
clv2.AddTextItem("3452	Κατηγορία 6.1	Ξυλιδίνες , στερεά	   " ,"")
clv2.AddTextItem("3453	Κατηγορία 8	Φωσφορικό οξύ , στερεό	   " ,"")
clv2.AddTextItem("3454	Κατηγορία 6.1	Dinitrotoluenes , στερεά	   " ,"")
clv2.AddTextItem("3455	Κατηγορία 6.1	Κρεζόλες , στερεά	   " ,"")
clv2.AddTextItem("3456	Κατηγορία 8	Nitrosylsulphuric οξύ , στερεό	   " ,"")
clv2.AddTextItem("3457	Κατηγορία 6.1	Chloronitrotoluenes , στερεά	   " ,"")
clv2.AddTextItem("3458	Κατηγορία 6.1	Nitroanisoles , στερεά	   " ,"")
clv2.AddTextItem("3459	Κατηγορία 6.1	Nitrobromobenzenes , στερεά	   " ,"")
clv2.AddTextItem("3460	Κατηγορία 6.1	Ν-Ethylbenzyltoluidines , στερεά	   " ,"")
clv2.AddTextItem("3462	Κατηγορία 6.1	Οι τοξίνες που προέρχονται από το ζωντανές πηγές, στερεά, 	   " ,"")
clv2.AddTextItem("3463	Κατηγορία 8	Προπιονικού οξέος με όχι λιγότερο από 90% κατά μάζα οξύ	   " ,"")
clv2.AddTextItem("3464	Κατηγορία 6.1	Οργανοφωσφορικές ένωση , τοξικά, στερεά, 	   " ,"")
clv2.AddTextItem("3465	Κατηγορία 6.1	Organoarsenic ένωση , στερεά, 	   " ,"")
clv2.AddTextItem("3466	Κατηγορία 6.1	Καρβονύλια μετάλλων , στερεά, 	   " ,"")
clv2.AddTextItem("3467	Κατηγορία 6.1	Οργανομεταλλική ένωση , τοξικά, στερεά, 	   " ,"")
clv2.AddTextItem("3468	Κατηγορία 2.1	Υδρογόνου σε υδριδίου μετάλλου σύστημα αποθήκευσης	   " ,"")
clv2.AddTextItem("3469	Κατηγορία 3	Ζωγραφική ,Paint συναφούς υλικού, εύφλεκτα, διαβρωτικά	   " ,"")
clv2.AddTextItem("3470	Κατηγορία 8	Ζωγραφική ,Paint συναφούς υλικού, διαβρωτικά, εύφλεκτα	" ,"")   
clv2.AddTextItem("3471	Κατηγορία 8	Διφθορίδια υδρογόνου λύση," ,"")
clv2.AddTextItem("3472	Κατηγορία 8	Κροτονικό οξύ , υγρό" ,"")
clv2.AddTextItem("3473	Κατηγορία 3	Κυψελών καυσίμου" ,"")
clv2.AddTextItem("3474	Κατηγορία 4.1	Υδροξυβενζοτριαζόλη , άνυδρο, βρεγμένο με όχι λιγότερο από 20% νερό, κατά βάρος" ,"")
clv2.AddTextItem("3475	Κατηγορία 3	Αιθανόλης και βενζίνης μίγμα ή αιθανόλη" ,"")
clv2.AddTextItem("3476	Κατηγορία 4.3	Κυψελών καυσίμου κασέτες ή κασέτες κυψελών καυσίμου" ,"")
clv2.AddTextItem("3477	Κατηγορία 8	Κυψελών καυσίμου κασέτες ή κασέτες κυψελών καυσίμου" ,"")
clv2.AddTextItem("3480	Κατηγορία 9	Ιόν λιθίου μπαταρίες συμπεριλαμβανομένων  ιόν λιθίου πολυμερούς μπαταρίες" ,"")
clv2.AddTextItem("3481	Κατηγορία 9	Μπαταρίες ιόν λιθίου" ,"")
clv2.AddTextItem("3482	Κατηγορία 4.3	Αλκαλίων διασπορά μετάλλου, εύφλεκτα ή αλκαλικών γαιών μέταλλο διασποράς, εύφλεκτο" ,"")
clv2.AddTextItem("3483	Κατηγορία 6.1	Μείγμα αντι-χτύπημα Motor καυσίμων , εύφλεκτα" ,"")
clv2.AddTextItem("3484	Κατηγορία 8	Υδατικό διάλυμα υδραζίνης, εύφλεκτες με περισσότερο από 37% υδραζίνη, κατά μάζα" ,"")
clv2.AddTextItem("3485	Κατηγορία 5.1	Υποχλωριώδες ασβέστιο" ,"")
clv2.AddTextItem("3486	Κατηγορία 5.1	Μείγμα υποχλωριώδους ασβεστίου	" ,"")
clv2.AddTextItem("3487	Κατηγορία 5.1	Υποχλωριώδες ασβέστιο, ενυδατωμένο, διαβρωτικές ή υποχλωριώδες ασβέστιο μείγμα" ,"")
clv2.AddTextItem("3489	Κατηγορία 6.1	Τοξικό υγρό εισπνοή, εύφλεκτα, διαβρωτικά" ,"")
clv2.AddTextItem("3494	Κατηγορία 3	Πετρέλαιο ξινή αργού πετρελαίου , εύφλεκτα, τοξικά" ,"")
clv2.AddTextItem("3495	Κατηγορία 8	Ιώδιο" ,"")
clv2.AddTextItem("3496	Κατηγορία 9	Μπαταρίες , νικελίου-υδριδίου μετάλλου" ,"")
clv2.AddTextItem("3497	Κατηγορία 4.2	Κριλ γεύμα" ,"")
clv2.AddTextItem("3498	Κατηγορία 8	Μονοχλωριούχο ιώδιο , υγρό" ,"")
clv2.AddTextItem("3499	Κατηγορία 9	Πυκνωτής" ,"")
   clv2.AddTextItem("3500	Κατηγορία 2.2	Χημική υπό πίεση, NOS" ,"")
End Sub

Sub clv1_ItemClick (Index As Int, Value As Object)
	Activity.Title = Value
End Sub

Sub CreateListItem(Text As String, Width As Int, Height As Int) As Panel
	Dim p As Panel
	p.Initialize("")
	p.Color = Colors.Black
	Dim b As Button
	b.Initialize("button") 'all buttons click events will be handled with Sub Button_Click
	Dim chk As CheckBox
	chk.Initialize("")
	Dim lbl As Label
	lbl.Initialize("")
	lbl.Gravity = Bit.Or(Gravity.CENTER_VERTICAL, Gravity.LEFT)
	lbl.Text = Text
	lbl.TextSize = 16
	lbl.TextColor = Colors.White
	b.Text = "Click"
	p.AddView(lbl, 5dip, 2dip, 150dip, Height - 4dip) 'view #0
	p.AddView(b, 155dip, 2dip, 110dip, Height - 4dip) 'view #1
	p.AddView(chk, 280dip, 2dip, 50dip, Height - 4dip) 'view #2
	Return p
End Sub



Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
Activity.Finish
End Sub

Sub ili_Click
	StartActivity("ilika")
End Sub
Sub ousia_Click
	StartActivity("ousies")
End Sub
Sub pixi_Click
	StartActivity("pixida")
End Sub

Sub lista_Click
	StartActivity("listaousies")
End Sub

Sub katigor_Click
	StartActivity("katigoriess")
End Sub
Sub gpss_Click
	
StartActivity("gpssingal")
End Sub

Sub simanseislabel_Click
	StartActivity("Main")
End Sub
Sub listabel_Click
	StartActivity("listaousies")
End Sub
Sub katigorlabel_Click
	StartActivity("katigoriess")
End Sub
Sub ousialabel_Click
	StartActivity("ousies")
End Sub
Sub ililabel_Click
	StartActivity("ilika")
End Sub

Sub simansi_Click
	StartActivity("Main")
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
    If KeyCode = KeyCodes.KEYCODE_BACK Then
      
             Activity.Finish
       End If
End Sub
