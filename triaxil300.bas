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

 

clv2.AddTextItem("3205	Κατηγορία 4.2	Μετάλλου αλκαλικής γαίας αλκοολικά, nos	" ,"")   
clv2.AddTextItem("3206	Κατηγορία 4.2	Αλκαλίων και αλκοολικά, αυτο-θέρμανση, διαβρωτικά, 	" ,"")    
clv2.AddTextItem("3208	Κατηγορία 4.3	Μεταλλικό ουσία, αντιδρούν με το νερό, 	   " ,"") 
clv2.AddTextItem("3209	Κατηγορία 4.3	Μεταλλικό ουσία, αντιδρούν με το νερό, αυτο-θέρμανσης, 	" ,"")    
clv2.AddTextItem("3210	Κατηγορία 5.1	Χλωρικά , ανόργανα, υδατικά διαλύματα, nos	   " ,"") 
clv2.AddTextItem("3211	Κατηγορία 5.1	Υπερχλωρικά άλατα, ανόργανα, υδατικό διάλυμα, nos	" ,"")    
clv2.AddTextItem("3212	Κατηγορία 5.1	Υποχλωριώδη , ανόργανα, 	   " ,"") 
clv2.AddTextItem("3213	Κατηγορία 5.1	Βρωμικά , ανόργανα, υδατικό διάλυμα, nos	   " ,"") 
clv2.AddTextItem("3214	Κατηγορία 5.1	Υπερμαγγανικά , ανόργανα, υδατικό διάλυμα, nos	   " ,"") 
clv2.AddTextItem("3215	Κατηγορία 5.1	Υπερθειικά , ανόργανα, 	   " ,"") 
clv2.AddTextItem("3216	Κατηγορία 5.1	Υπερθειικά, ανόργανα, υδατικό διάλυμα, nos	  " ,"")    
clv2.AddTextItem("3218	Κατηγορία 5.1	Νιτρικά άλατα , ανόργανα, υδατικό διάλυμα, 	  " ,"")  
clv2.AddTextItem("3219	Κατηγορία 5.1	Νιτρωδών , ανόργανα, υδατικό διάλυμα, nos	  " ,"")  
clv2.AddTextItem("3220	Κατηγορία 2.2	Πενταφθοροαιθάνιο ή ψυκτικό αέριο R 125	 " ,"")   
clv2.AddTextItem("3221	Κατηγορία 4.1	Αυτο-αντιδραστικό υγρό τύπου Β	   " ,"") 
clv2.AddTextItem("3222	Κατηγορία 4.1	Αυτο-αντιδραστικά στερεά τύπου Β	   " ,"") 
clv2.AddTextItem("3223	Κατηγορία 4.1	Αυτο-αντιδραστικό υγρό τύπου C	   " ,"") 
clv2.AddTextItem("3224	Κατηγορία 4.1	Αυτο-αντιδραστικά στερεά τύπου C	   " ,"") 
clv2.AddTextItem("3225	Κατηγορία 4.1	Αυτο-αντιδραστικό υγρό τύπου D	   " ,"") 
clv2.AddTextItem("3226	Κατηγορία 4.1	Αυτο-αντιδραστικά στερεά τύπου D	   " ,"") 
clv2.AddTextItem("3227	Κατηγορία 4.1	Αυτο-αντιδραστικό υγρό τύπου E	   " ,"") 
clv2.AddTextItem("3228	Κατηγορία 4.1	Αυτο-αντιδραστικά στερεά τύπου E	   " ,"") 
clv2.AddTextItem("3229	Κατηγορία 4.1	Αυτο-αντιδραστικό υγρό τύπου F	   " ,"") 
clv2.AddTextItem("3230	Κατηγορία 4.1	Αυτο-αντιδραστικά στερεά τύπου F	   " ,"") 
clv2.AddTextItem("3231	Κατηγορία 4.1	Αυτο-αντιδραστικό υγρό τύπου Β, ελεγχόμενη θερμοκρασία	" ,"")    
clv2.AddTextItem("3232	Κατηγορία 4.1	Αυτο-αντιδραστικά στερεά τύπου B, υπό ελεγχόμενη θερμοκρασία	" ,"")    
clv2.AddTextItem("3233	Κατηγορία 4.1	Αυτο-αντιδραστικό υγρό τύπου C, υπό ελεγχόμενη θερμοκρασία	" ,"")    
clv2.AddTextItem("3234	Κατηγορία 4.1	Αυτο-αντιδραστικά στερεά τύπου C, υπό ελεγχόμενη θερμοκρασία	" ,"")    
clv2.AddTextItem("3235	Κατηγορία 4.1	Αυτο-αντιδραστικό υγρό τύπου D, υπό ελεγχόμενη θερμοκρασία	" ,"")    
clv2.AddTextItem("3236	Κατηγορία 4.1	Αυτο-αντιδραστικά στερεά τύπου D, υπό ελεγχόμενη θερμοκρασία	" ,"")    
clv2.AddTextItem("3237	Κατηγορία 4.1	Αυτο-αντιδραστικό υγρό τύπου E, υπό ελεγχόμενη θερμοκρασία	" ,"")    
clv2.AddTextItem("3238	Κατηγορία 4.1	Αυτο-αντιδραστικά στερεά τύπου E, υπό ελεγχόμενη θερμοκρασία	" ,"")    
clv2.AddTextItem("3239	Κατηγορία 4.1	Αυτο-αντιδραστικό υγρό τύπου F, υπό ελεγχόμενη θερμοκρασία	" ,"")    
clv2.AddTextItem("3240	Κατηγορία 4.1	Αυτο-αντιδραστικά στερεά τύπου F, υπό ελεγχόμενη θερμοκρασία	" ,"")    
clv2.AddTextItem("3241	Κατηγορία 4.1	βρωμο-νιτροπροπάνιο-διόλη	   " ,"") 
clv2.AddTextItem("3242	Κατηγορία 4.1	Αζοδικαρβοναμιδίου	   " ,"") 
clv2.AddTextItem("3243	Κατηγορία 6.1	Στερεά που περιέχουν τοξικά υγρά, 	   " ,"") 
clv2.AddTextItem("3244	Κατηγορία 8	Στερεά που περιέχουν διαβρωτικά υγρά, 	   " ,"") 
clv2.AddTextItem("3245	Κατηγορία 9	Γενετικά τροποποιημένοι μικροοργανισμοί ή γενετικά τροποποιημένων οργανισμών" ,"") 	   
clv2.AddTextItem("3246	Κατηγορία 6.1	Μεθανοσουλφονυλοχλωρίδιο	   " ,"") 
clv2.AddTextItem("3247	Κατηγορία 5.1	Υπεροξοβορικό νάτριο , άνυδρο,	   " ,"") 
clv2.AddTextItem("3248	Κατηγορία 3	Ιατρική , υγρά, εύφλεκτα, τοξικά, 	   " ,"") 
clv2.AddTextItem("3249	Κατηγορία 6.1	Βουπιβακαΐνη Μονοϋδρική υδροχλωρική, στερεά, τοξικά, 	   " ,"") 
clv2.AddTextItem("3250	Κατηγορία 6.1	Χλωροοξικό οξύ , λιωμένο	   " ,"") 
clv2.AddTextItem("3251	Κατηγορία 4.1	Μονονιτρικό-Κατηγορία Κατηγορία 5-μονονιτρική	   " ,"") 
clv2.AddTextItem("3252	Κατηγορία 2.1	Διφθορομεθάνιο ή ψυκτικό αέριο R 32	   " ,"") 
clv2.AddTextItem("3253	Κατηγορία 8	Δινάτριο trioxosilicate	   " ,"") 
clv2.AddTextItem("3254	Κατηγορία 4.2	Τριβουτυλοφωσφάνιο	   " ,"") 
clv2.AddTextItem("3255	Κατηγορία 4.2	τριτ-βουτυλο υποχλωριώδες	         	   " ,"") 
clv2.AddTextItem("3259	Κατηγορία 8	Αμίνες , στερεά, διαβρωτικά,  ή πολυαμίνες, στερεές, διαβρωτικές, 	 " ,"")   
clv2.AddTextItem("3260	Κατηγορία 8	Διαβρωτικό στερεό, όξινα, ανόργανα, 	   " ,"") 
clv2.AddTextItem("3261	Κατηγορία 8	Διαβρωτικό στερεό, όξινα, οργανικά, 	   " ,"") 
clv2.AddTextItem("3262	Κατηγορία 8	Διαβρωτικό στερεό, βασικά, ανόργανα, 	   " ,"") 
clv2.AddTextItem("3263	Κατηγορία 8	Διαβρωτικό στερεό, βασικά, οργανικά, 	   " ,"") 
clv2.AddTextItem("3264	Κατηγορία 8	Διαβρωτικό υγρό, όξινα, ανόργανα, 	   " ,"") 
clv2.AddTextItem("3265	Κατηγορία 8	Διαβρωτικό υγρό, όξινα, οργανικά, 	   " ,"") 
clv2.AddTextItem("3266	Κατηγορία 8	Διαβρωτικό υγρό, βασικά, ανόργανα, 	   " ,"") 
clv2.AddTextItem("3267	Κατηγορία 8	Διαβρωτικό υγρό, βασικά, οργανικά, 	   " ,"") 
clv2.AddTextItem("3268	Κατηγορία 9	Διογκώνουν αερόσακο ή μονάδες αερόσακου ή προεντατήρες ζωνών ασφαλείας	 " ,"")   
clv2.AddTextItem("3269	Κατηγορία 3	Polyester κιτ ρητίνης	   " ,"") 
clv2.AddTextItem("3270	Κατηγορία 4.1	Νιτροκυτταρίνης φίλτρα μεμβράνης	   " ,"") 
clv2.AddTextItem("3271	Κατηγορία 3	Αιθέρες , 	   " ,"") 
clv2.AddTextItem("3272	Κατηγορία 3	Εστέρες , 	   " ,"") 
clv2.AddTextItem("3273	Κατηγορία 3	Νιτρίλια , εύφλεκτα, τοξικά, 	" ,"")    
clv2.AddTextItem("3274	Κατηγορία 3	Αλκοολικά  - αλκοόλ	" ,"")    
clv2.AddTextItem("3275	Κατηγορία 6.1	Νιτρίλια, τοξικό, εύφλεκτο, 	 " ,"")   
clv2.AddTextItem("3276	Κατηγορία 6.1	Νιτρίλια, τοξικό, υγρό, nos	   " ,"") 
clv2.AddTextItem("3277	Κατηγορία 6.1	Χλωρομυρμηκικούς , τοξικά, διαβρωτικά," ,"") 
clv2.AddTextItem("3278	Κατηγορία 6.1	Οργανοφωσφορικές ένωση, τοξικό, υγρό," ,"") 
clv2.AddTextItem("3279	Κατηγορία 6.1	Οργανοφωσφορικές ένωση, τοξικά, εύφλεκτα," ,"") 
clv2.AddTextItem("3280	Κατηγορία 6.1	Organoarsenic ένωση," ,"") 
clv2.AddTextItem("3281	Κατηγορία 6.1	Καρβονύλια μετάλλων , υγρό," ,"") 
clv2.AddTextItem("3282	Κατηγορία 6.1	Οργανομεταλλική ένωση, τοξικό, υγρό," ,"") 
clv2.AddTextItem("3283	Κατηγορία 6.1	Σελήνιο ένωση, στερεά," ,"") 
clv2.AddTextItem("3284	Κατηγορία 6.1	Τελλούριο ένωση, στερεά," ,"") 
clv2.AddTextItem("3285	Κατηγορία 6.1	Βαναδίου ένωση," ,"") 
clv2.AddTextItem("3286	Κατηγορία 3	Εύφλεκτα υγρά, τοξικά, διαβρωτικά," ,"") 
clv2.AddTextItem("3287	Κατηγορία 6.1	Τοξικό υγρό" ,"") 
clv2.AddTextItem("3288	Κατηγορία 6.1	Τοξικά στερεά, ανόργανα," ,"") 
clv2.AddTextItem("3290	Κατηγορία 6.1	Τοξικά στερεά, διαβρωτικά, ανόργανα," ,"") 
clv2.AddTextItem("3291	Κατηγορία 6.2	Κλινικά απόβλητα ή ελεγχόμενα ιατρικά απόβλητα," ,"") 
clv2.AddTextItem("3292	Κατηγορία 4.3	Μπαταρίες , που περιέχουν νάτριο, ή, που περιέχουν νάτριο" ,"") 
clv2.AddTextItem("3293	Κατηγορία 6.1	Υδραζίνη , υδατικό διάλυμα με όχι περισσότερο από 37 τοις εκατό υδραζίνη, κατά βάρος" ,"") 
clv2.AddTextItem("3294	Κατηγορία 6.1	Υδροκυάνιο , διάλυμα σε αλκοόλη με όχι περισσότερο από 45 τοις εκατό υδροκυάνιο" ,"") 
clv2.AddTextItem("3295	Κατηγορία 3	Υδρογονάνθρακες , υγρό," ,"") 
clv2.AddTextItem("3296	Κατηγορία 2.2	Επταφθοριοπροπάνιο ή ψυκτικό αέριο R 227" ,"") 
clv2.AddTextItem("3297	Κατηγορία 2.2	Οξείδιο του αιθυλενίου και χλωροτετραφθοροαιθάνιο" ,"") 
clv2.AddTextItem("3298	Κατηγορία 2.2	Οξειδίου του αιθυλενίου και πενταφθοροαιθάνιο" ,"") 
clv2.AddTextItem("3299	Κατηγορία 2.2	Οξειδίου του αιθυλενίου και " ,"") 
   clv2.AddTextItem("3300	Κατηγορία 2.3	Οξειδίου του αιθυλενίου και διοξειδίου του άνθρακα" ,"") 





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
