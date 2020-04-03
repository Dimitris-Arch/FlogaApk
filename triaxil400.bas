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

 
clv2.AddTextItem("3301	Κατηγορία 8	Διαβρωτικό υγρό, αυτο-θέρμανσης, 	   " ,"") 
clv2.AddTextItem("3302	Κατηγορία 6.1	Κατηγορία 2-διμεθυλαμινοαιθυλ ακρυλικό	   " ,"") 
clv2.AddTextItem("3303	Κατηγορία 2.3	Συμπιεσμένο αέριο, τοξικά, οξειδωτικά, 	   " ,"") 
clv2.AddTextItem("3304	Κατηγορία 2.3	Συμπιεσμένο αέριο, τοξικά, διαβρωτικά, 	   " ,"") 
clv2.AddTextItem("3305	Κατηγορία 2.3	Συμπιεσμένο αέριο, τοξικά, εύφλεκτα, διαβρωτικά, 	   " ,"") 
clv2.AddTextItem("3306	Κατηγορία 2.3	Συμπιεσμένο αέριο, τοξικά, οξειδωτικά, διαβρωτικά, 	   " ,"") 
clv2.AddTextItem("3307	Κατηγορία 2.3	Υγροποιημένα αέρια, τοξικά, οξειδωτικά, 	   " ,"") 
clv2.AddTextItem("3308	Κατηγορία 2.3	Υγροποιημένα αέρια, τοξικά, διαβρωτικά, 	   " ,"") 
clv2.AddTextItem("3309	Κατηγορία 2.3	Υγροποιημένα αέρια, τοξικά, εύφλεκτα, διαβρωτικά, 	   " ,"") 
clv2.AddTextItem("3310	Κατηγορία 2.3	Υγροποιημένα αέρια, τοξικά, οξειδωτικά, διαβρωτικά, 	   " ,"") 
clv2.AddTextItem("3311	Κατηγορία 2.2	Αερίου, κατεψυγμένο, υγρό, οξειδωτικά, 	   " ,"") 
clv2.AddTextItem("3312	Κατηγορία 2.1	Αερίου, ψυγείο υγρό, εύφλεκτο, 	   " ,"") 
clv2.AddTextItem("3313	Κατηγορία 4.2	Οργανικές χρωστικές, αυτο-θέρμανσης	   " ,"") 
clv2.AddTextItem("3314	Κατηγορία 9	Ένωση πλαστικού καλουπώματος σε ζύμη   " ,"") 
clv2.AddTextItem("3315	Κατηγορία 6.1	Χημικό δείγμα, τοξικό	   " ,"") 
clv2.AddTextItem("3316	Κατηγορία 9	Chemical kit ή το κιτ πρώ βοηθειών περιέχει επικίνδυνα εμπορεύματα	   " ,"") 
clv2.AddTextItem("3317	Κατηγορία 4.1	Αμινο-δινιτροφαινόλη	   " ,"") 
clv2.AddTextItem("3318	Κατηγορία 2.3	Αμμωνία διάλυμα	   " ,"") 
clv2.AddTextItem("3319	Κατηγορία 4.1	Η νιτρογλυκερίνη μείγμα, απευαισθητοποιημένοι" ,"") 
clv2.AddTextItem("3320	Κατηγορία 8	Βοροϋδριδίου του νατρίου και υδροξείδιο του νατρίου" ,"") 
clv2.AddTextItem("3321	Κατηγορία 7	Ραδιενεργό υλικό, χαμηλή σχετική δραστικότητα LSA-II) , μη-σχάσιμο ή σχάσιμο εξαιρούμενο" ,"") 	   
clv2.AddTextItem("3322	Κατηγορία 7	Ραδιενεργό υλικό, χαμηλή σχετική δραστικότητα LSA-III) , μη-σχάσιμο ή σχάσιμο εξαιρούμενο" ,"") 	   
clv2.AddTextItem("3323	Κατηγορία 7	Ραδιενεργό υλικό, κόλου Τύπου C , μη-σχάσιμο ή σχάσιμο εξαιρούμενο	   " ,"") 
clv2.AddTextItem("3324	Κατηγορία 7	Ραδιενεργό υλικό, χαμηλή σχετική δραστικότητα LSA-II) , σχάσιμο	   " ,"") 
clv2.AddTextItem("3325	Κατηγορία 7	Ραδιενεργό υλικό, χαμηλή σχετική δραστικότητα LSA-III) , σχάσιμο	   " ,"") 
clv2.AddTextItem("3326	Κατηγορία 7	Ραδιενεργό υλικό, επιφανειακά μολυσμένα αντικείμενα SCO-I ή SCO-II) , σχάσιμο	   " ,"") 
clv2.AddTextItem("3327	Κατηγορία 7	Ραδιενεργό υλικό, κόλο Τύπου Α , σχάσιμο , μη ειδικό έντυπο	   " ,"") 
clv2.AddTextItem("3328	Κατηγορία 7	Ραδιενεργό υλικό, Τύπου B U συσκευασία , σχάσιμο	   " ,"") 
clv2.AddTextItem("3329	Κατηγορία 7	Ραδιενεργό υλικό, Τύπου B M συσκευασία , σχάσιμο	   " ,"") 
clv2.AddTextItem("3330	Κατηγορία 7	Ραδιενεργό υλικό, κόλου Τύπου C , σχάσιμο	   " ,"") 
clv2.AddTextItem("3331	Κατηγορία 7	Ραδιενεργό υλικό, μεταφέρονται υπό ειδικές ρυθμίσεις, σχάσιμο	   " ,"") 
clv2.AddTextItem("3332	Κατηγορία 7	Ραδιενεργό υλικό, κόλο Τύπου Α , ειδική μορφή, μη-σχάσιμο ή σχάσιμο εξαιρούμενο	" ,"")    
clv2.AddTextItem("3333	Κατηγορία 7	Ραδιενεργό υλικό, κόλο Τύπου Α , ειδική μορφή, σχάσιμο	   " ,"") 
clv2.AddTextItem("3334	Κατηγορία 9	Αεροπορίας ρυθμιζόμενη υγρό, 	   " ,"") 
clv2.AddTextItem("3335	Κατηγορία 9	Της πολιτικής αεροπορίας ρυθμίζονται στερεά, 	   " ,"") 
clv2.AddTextItem("3336	Κατηγορία 3	Μερκαπτάνες , υγρό, εύφλεκτο,  ή μερκαπτάνη μίγμα, υγρό, εύφλεκτο, 	   " ,"") 
clv2.AddTextItem("3337	Κατηγορία 2.2	Ψυκτικό αέριο R404A	   " ,"") 
clv2.AddTextItem("3338	Κατηγορία 2.2	Ψυκτικό αέριο R407A	   " ,"") 
clv2.AddTextItem("3339	Κατηγορία 2.2	Ψυκτικό αέριο R407B	   " ,"") 
clv2.AddTextItem("3340	Κατηγορία 2.2	Ψυκτικό αέριο R407C	   " ,"") 
clv2.AddTextItem("3341	Κατηγορία 4.2	Διοξείδιο Θειουρία	   " ,"") 
clv2.AddTextItem("3342	Κατηγορία 4.2	Ξανθάτες	   " ,"") 
clv2.AddTextItem("3343	Κατηγορία 3	Νιτρογλυκερίνη   " ,"") 
clv2.AddTextItem("3344	Κατηγορία 4.1	Πενταερυθριτόλη τετρανιτρικό   " ,"") 
clv2.AddTextItem("3345	Κατηγορία 6.1	Φαινοξυοξικού οξέος φυτοφαρμάκων , στερεά, τοξικά	   " ,"") 
clv2.AddTextItem("3346	Κατηγορία 3	Φαινοξυοξικού παράγωγο παρασιτοκτόνο , υγρό, εύφλεκτο, τοξικό σημείο ανάφλεξης μικρότερο από 23 ° C	" ,"")    
clv2.AddTextItem("3347	Κατηγορία 6.1	Φαινοξυοξικό οξύ παράγωγο φυτοφάρμακο , υγρά, τοξικά, εύφλεκτα σημείο ανάφλεξης 23 ° C ή περισσότερο" ,"") 	   
clv2.AddTextItem("3348	Κατηγορία 6.1	Φαινοξυοξικού παράγωγο παρασιτοκτόνο , υγρό, τοξικό	   " ,"") 
clv2.AddTextItem("3349	Κατηγορία 6.1	Πυρεθροειδή φυτοφαρμάκων , στερεά, τοξικά	   " ,"") 
clv2.AddTextItem("3350	Κατηγορία 3	    Πυρεθροειδή παρασιτοκτόνο , υγρό, εύφλεκτο, τοξικό σημείο ανάφλεξης μικρότερο από 23 ° C	" ,"")    
clv2.AddTextItem("3351	Κατηγορία 6.1	Πυρεθροειδή παρασιτοκτόνο , υγρό, τοξικό, εύφλεκτο σημείο ανάφλεξης 23 ° C ή περισσότερο" ,"") 	   
clv2.AddTextItem("3352	Κατηγορία 6.1	Πυρεθροειδή παρασιτοκτόνο , υγρό, τοξικό	      " ,"") 
clv2.AddTextItem("3354	Κατηγορία 2.1	Εντομοκτόνο αέριο, εύφλεκτο, 	   " ,"") 
clv2.AddTextItem("3355	Κατηγορία 2.3	Εντομοκτόνο αέριο, τοξικό, εύφλεκτο, 	   " ,"") 
clv2.AddTextItem("3356	Κατηγορία 5.1	Οξυγόνο γεννήτρια, χημικά	   " ,"") 
clv2.AddTextItem("3357	Κατηγορία 3	    Nιτρογλυκερίνη μείγμα   " ,"") 
clv2.AddTextItem("3358	Κατηγορία 2.1	Ψυκτικές μηχανές, που περιέχουν εύφλεκτα, μη-τοξικά, υγροποιημένο αέριο	" ,"")    
clv2.AddTextItem("3359	Κατηγορία 9	   Σε υποκαπνισμό μονάδα	   " ,"") 
clv2.AddTextItem("3360	Κατηγορία 4.1	Ίνες, λαχανικών, ξηρών	   " ,"") 
clv2.AddTextItem("3361	Κατηγορία 6.1	Χλωροσιλάνι , τοξικά, διαβρωτικά, 	   " ,"") 
clv2.AddTextItem("3362	Κατηγορία 6.1	Χλωροσιλανίων , τοξικά, διαβρωτικά, εύφλεκτα, 	   " ,"") 
clv2.AddTextItem("3363	Κατηγορία 9	    Επικίνδυνα εμπορεύματα σε μηχανήματα ή επικίνδυνα εμπορεύματα σε συσκευή	   " ,"") 
clv2.AddTextItem("3364	Κατηγορία 4.1	Τρινιτροφαινόλη  πικρικό οξύ ), βρεγμένη με όχι λιγότερο από 10% νερό κατά βάρος	   " ,"") 
clv2.AddTextItem("3365	Κατηγορία 4.1	Τρινιτροχλωροβενζόλιο  πικρυλοχλωρίδιο ), βρεγμένη με όχι λιγότερο από 10% νερό κατά βάρος	" ,"")    
clv2.AddTextItem("3366	Κατηγορία 4.1	Τρινιτροτολουένιο TNT), βρεγμένη με όχι λιγότερο από 10% νερό κατά μάζα	   " ,"") 
clv2.AddTextItem("3367	Κατηγορία 4.1	Τρινιτροβενζόλιο , βρεγμένο με όχι λιγότερο από 10% νερό κατά βάρος	   " ,"") 
clv2.AddTextItem("3368	Κατηγορία 4.1	Τρινιτροβενζοϊκό οξύ , βρεγμένο με όχι λιγότερο από 10% νερό κατά βάρος	   " ,"") 
clv2.AddTextItem("3369	Κατηγορία 4.1	Δινιτρο-ο-κρεζολικό νάτριο , βρεγμένο με όχι λιγότερο από 10% νερό κατά βάρος	   " ,"") 
clv2.AddTextItem("3370	Κατηγορία 4.1	Νιτρική ουρία , βρεγμένη με όχι λιγότερο από 10% νερό κατά βάρος	   " ,"") 
clv2.AddTextItem("3371	Κατηγορία 3	    Mεθυλβουτανάλης	   " ,"") 
clv2.AddTextItem("3373	Κατηγορία 6.2	Βιολογική ουσία,  Β	   " ,"") 
clv2.AddTextItem("3374	Κατηγορία 2.1	Ακετυλένιο , χωρίς διαλύτες	   " ,"") 
clv2.AddTextItem("3375	Κατηγορία 5.1	Νιτρικό αμμώνιο γαλάκτωμα ή αναστολή ή τζελ	   " ,"") 
clv2.AddTextItem("3376	Κατηγορία 4.1	Κατηγορία 4-νιτροφαινυλο , με όχι λιγότερο από 30% νερό κατά βάρος	   " ,"") 
clv2.AddTextItem("3377	Κατηγορία 5.1	Μονοένυδρο υπερβορικό νάτριο	   " ,"") 
clv2.AddTextItem("3378	Κατηγορία 5.1	Υπεροξυένυδρο ανθρακικό νάτριο	   " ,"") 
clv2.AddTextItem("3379  Κατηγορία 3	    Απευαισθητοποιημένες εκρηκτικά , υγρό, 	   " ,"") 
clv2.AddTextItem("3380	Κατηγορία 4.1	Απευαισθητοποιημένες εκρηκτικά, στερεά, 	" ,"")    
clv2.AddTextItem("3381	Κατηγορία 6.1	Τοξικό με εισπνοή liquid   " ,"") 
clv2.AddTextItem("3382	Κατηγορία 6.1	Τοξικό υγρό από εισπνοή, " ,"") 
clv2.AddTextItem("3383	Κατηγορία 6.1	Τοξικό όταν εισπνέεται υγρό, εύφλεκτο" ,"") 
clv2.AddTextItem("3384	Κατηγορία 6.1	Τοξικό όταν εισπνέεται υγρό, εύφλεκτο" ,"") 
clv2.AddTextItem("3385	Κατηγορία 6.1	Τοξικό υγρό από εισπνοή, αντιδρούν με το νερo	" ,"")    
clv2.AddTextItem("3387	Κατηγορία 6.1	Τοξικό υγρό από εισπνοή, οξειδωτικά	" ,"") 
clv2.AddTextItem("3388	Κατηγορία 6.1	Τοξικό υγρό εισπνοή, οξειδωτικά	   	" ,"") 
clv2.AddTextItem("3391	Κατηγορία 4.2	Οργανομεταλλικοί ουσία, στερεά, πυροφορικά	" ,"") 
clv2.AddTextItem("3392	Κατηγορία 4.2	Οργανομεταλλικοί ουσία, υγρό, πυροφορικά	" ,"") 
clv2.AddTextItem("3393	Κατηγορία 4.2	Οργανομεταλλικοί ουσία, στερεά, πυροφορικό , αντιδρούν με το νερό	" ,"") 
clv2.AddTextItem("3394	Κατηγορία 4.2	Οργανομεταλλικοί ουσία, υγρό, πυροφορικό , αντιδρούν με το νερό	" ,"") 
clv2.AddTextItem("3395	Κατηγορία 4.3	Οργανομεταλλικοί ουσία, στερεά, αντιδρούν με το νερό	" ,"") 
clv2.AddTextItem("3396	Κατηγορία 4.3	Οργανομεταλλικοί ουσία, στερεά, αντιδρούν με το νερό, εύφλεκτο	" ,"") 
clv2.AddTextItem("3397	Κατηγορία 4.3	Οργανομεταλλικοί ουσία, στερεά, αντιδρούν με το νερό, αυτο-θέρμανσης	" ,"") 
clv2.AddTextItem("3398	Κατηγορία 4.3	Οργανομεταλλικό ουσία, υγρό, αντιδρούν με το νερό	" ,"") 
clv2.AddTextItem("3399	Κατηγορία 4.3	Οργανομεταλλικοί ουσία, υγρό, αντιδρούν με το νερό, εύφλεκτο	" ,"") 
   clv2.AddTextItem("3400	Κατηγορία 4.3	Οργανομεταλλικό ουσία, υγρό, αντιδρούν με το νερό, αυτο-θέρμανση	" ,"") 

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

