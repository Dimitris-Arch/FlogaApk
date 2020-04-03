B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=8
@EndOfDesignText@
'version 1.00
'Class module
Sub Class_Globals
	Private prefixList As Map
	Private substringList As Map
	Private et As EditText
	Private lv As ListView
	Private MIN_LIMIT, MAX_LIMIT As Int
	MIN_LIMIT = 1
	MAX_LIMIT = 4 'doesn't limit the words length. Only the index.
	Private mCallback As Object
	Private mEventName As String
	Private listaPrin As ListView

End Sub

'Initializes the object and sets the module and sub that will handle the ItemClick event
Public Sub Initialize (Callback As Object, EventName As String)
	et.Initialize("et")
	'Remove the suggestions bar
	et.InputType = Bit.Or(et.INPUT_TYPE_TEXT, 0x00080000)

	lv.Initialize("lv")
	lv.SingleLineLayout.ItemHeight = 50dip
	lv.SingleLineLayout.Label.TextSize = 14
	lv.Visible = False
	lv.Color = Colors.DarkGray
	prefixList.Initialize
	substringList.Initialize
	mCallback = Callback
	mEventName = EventName
End Sub

'Adds the view to the parent. The parent can be an Activity or Panel.
Public Sub AddToParent(Parent As Panel, Left As Int, Top As Int, Width As Int, Height As Int)
	Parent.AddView(et, Left, Top, Width - 5%x , 60dip)
	Parent.AddView(lv, Left, Top + et.Height, Width, Height - et.Height)

	listaPrin.Initialize("listaPrin")
	listaPrin.Color = Colors.DarkGray
	
	listaPrin.AddSingleLine("0004-Κατηγορια 1.1D Πικρικο αμμωνιο , ξηρος η νωπος με λιγοτερο απο Κατηγορια 10 τοις εκατο νερο, κατα βαρος  ")
	listaPrin.AddSingleLine("0005-Κατηγορια 1.1E Φυσιγγια για οπλα, με εκρηκτικη γομωση  ")
	listaPrin.AddSingleLine("0009-Κατηγορια 1 Πυρομαχικα , εμπρηστικα με η χωρις ρηγμα, διαρροη γομωσης η προωθητικης γομωσης  ")
	listaPrin.AddSingleLine("0012-Κατηγορια 1 Φυσιγγια για οπλα, αδρανους βληματος η Φυσιγγια, μικρων οπλων  ")
	listaPrin.AddSingleLine("0014-Κατηγορια 1 Φυσιγγια για οπλα, κενο η Φυσιγγια, μικρων οπλων, κενο  ")
	listaPrin.AddSingleLine("0015-Κατηγορια 1 Πυρομαχικα, καπνο, με η χωρις ρηγμα, διαρροη γομωσης η προωθητικης γομωσης")
	listaPrin.AddSingleLine("0018-Κατηγορια 1 Πυρομαχικα, δακρυ-παραγωγη με ρηγμα, διαρροη γομωσης η προωθητικης γομωσης ")
	listaPrin.AddSingleLine("0020-Κατηγορια 1 Πυρομαχικα, τοξικα με ρηγμα, διαρροη γομωσης η προωθητικης γομωσης  ")
	listaPrin.AddSingleLine("0027-Κατηγορια 1 Μαυρη σκονη η Μπαρουτι, κοκκωδης η ως ενα γευμα  ")
	listaPrin.AddSingleLine("0028-Κατηγορια 1 Μαυρη σκονη, συμπιεσμενα η Μπαρουτι, συμπιεσμενα η Μαυρη σκονη, σε σφαιριδια η Μπαρουτι, σε σφαιριδια  ")
	listaPrin.AddSingleLine("0029-Κατηγορια 1 Πυροκροτητες , ηλεκτρικα ειδη, μη ηλεκτρικα, για ανατιναξεις  ")
	listaPrin.AddSingleLine("0033-Κατηγορια 1 Βομβες , με εκρηκτικη γομωση  ")
	listaPrin.AddSingleLine("0037-Κατηγορια 1 ΒΟΜΒΕΣ, φλας  ")
	listaPrin.AddSingleLine("0042-Κατηγορια 1 Ενισχυτες , χωρις πυροκροτητη")
	listaPrin.AddSingleLine("0043-Κατηγορια 1 Γαμα , εκρηκτικα  ")
	listaPrin.AddSingleLine("0044-Κατηγορια 1 Ασταρια , τυπος καπακι")
	listaPrin.AddSingleLine("0048-Κατηγορια 1 Χρεωσεις , κατεδαφιση  ")
	listaPrin.AddSingleLine("0049-Κατηγορια 1 Φυσιγγια, φλας  ")
	listaPrin.AddSingleLine("0054-Κατηγορια 1 Φυσιγγια, σημα  ")
	listaPrin.AddSingleLine("0055-Κατηγορια 1 Θηκες, φυσιγγιων, αδειο, με ασταρι  ")
	listaPrin.AddSingleLine("0056-Κατηγορια 1 Χρεωσεις, το βαθος  ")
	listaPrin.AddSingleLine("0059-Κατηγορια 1 Χρεωσεις, σχημα, χωρις πυροκροτητη  ")
	listaPrin.AddSingleLine("0060-Κατηγορια 1 Χρεωσεις, συμπληρωματικη εκρηκτικα  ")
	listaPrin.AddSingleLine("0065-Κατηγορια 1 Καλωδιο , εκρηκτικων, ευελικτη  ")
	listaPrin.AddSingleLine("0066-Κατηγορια 1 Καλωδιο, αναφλεξη    ")
	listaPrin.AddSingleLine("0070-Κατηγορια 1 Κοφτες, καλωδιο, εκρηκτικα  ")
	listaPrin.AddSingleLine("0072-Κατηγορια 1 Κυκλοτριμεθυλενοτρινιτραμινη   ")
	listaPrin.AddSingleLine("0073-Κατηγορια 1 Πυροκροτητες για τα πυρομαχικα  ")
	listaPrin.AddSingleLine("0074-Κατηγορια 1 Diazodinitrophenol , βρεγμενο με οχι λιγοτερο απο 40 τοις εκατο νερο η μιγμα αλκοολης και νερου, κατα βαρος  ")
	listaPrin.AddSingleLine("0075-Κατηγορια 1 Διαιθυλενογλυκολη δινιτρικο  ")
	listaPrin.AddSingleLine("0076-Κατηγορια 1 Δινιτροφαινολης , ξηρος η νωπος με λιγοτερο απο Κατηγορια 15 τοις εκατο νερο κατα μαζα  ")
	listaPrin.AddSingleLine("0077-Κατηγορια 1 Dinitrophenolates αλκαλικα μεταλλα , ξηρος η νωπος με λιγοτερο απο Κατηγορια 15 τοις εκατο νερο κατα μαζα  ")
	listaPrin.AddSingleLine("0078-Κατηγορια 1 Dinitroresorcinol , ξηρος η νωπος με λιγοτερο απο Κατηγορια 15 τοις εκατο νερο κατα μαζα  ")
	listaPrin.AddSingleLine("0079-Κατηγορια 1 Hexanitrodiphenylamine η Dipicrylamine η Hexyl  ")
	listaPrin.AddSingleLine("0081-Κατηγορια 1 Εκρηκτικο , ανατιναξεις, τυπου Α  ")
	listaPrin.AddSingleLine("0082-Κατηγορια 1 Εκρηκτικο, ανατιναξεις, τυπου Β  ")
	listaPrin.AddSingleLine("0083-Κατηγορια 1 Εκρηκτικο, ανατιναξεις, τυπου C  ")
	listaPrin.AddSingleLine("0084-Κατηγορια 1 Εκρηκτικο, ανατιναξεις, τυπου D  ")
	listaPrin.AddSingleLine("0092-Κατηγορια 1 Φωτοβολιδες , επιφανεια  ")
	listaPrin.AddSingleLine("0093-Κατηγορια 1 Φωτοβολιδες, εναερια  ")
	listaPrin.AddSingleLine("0094-Κατηγορια 1 Blitzlichtpulver (Flash σκονη, π.χ. για μια ντεμοντε φλας της φωτογραφικης μηχανης") 
	listaPrin.AddSingleLine("0099-Κατηγορια 1 Συσκευες, εκρηκτικα, θραυση χωρις πυροκροτητες για πετρελαιοπηγες   ")
	
	
	
	Parent.AddView(listaPrin, 3%x, 33%y + 60dip,94%x ,57.5%y - 60dip)
	listaPrin.SingleLineLayout.Label.TextSize = 14
	
End Sub
Sub listaPrin_ItemClick (Position As Int, Value As Object)
	ToastMessageShow(Value, True)
End Sub
Private Sub lv_ItemClick (Position As Int, Value As Object)
	et.Text = Value
	
	et.SelectionStart = et.Text.Length
	Dim IME As IME
	IME.HideKeyboard
	lv.Visible = False
	If SubExists(mCallback, mEventName & "_ItemClick") Then
		CallSub2(mCallback, mEventName & "_ItemClick", Value)
	End If
End Sub

Private Sub et_TextChanged (Old As String, New As String)
	lv.Clear
	listaPrin.Clear
	listaPrin.Visible = False
	If lv.Visible = False Then lv.Visible = True
	If New.Length < MIN_LIMIT Then Return
	Dim str1, str2 As String
	str1 = New.ToLowerCase
	If str1.Length > MAX_LIMIT Then
		str2 = str1.SubString2(0, MAX_LIMIT)
	Else
		str2 = str1
	End If
	AddItemsToList(prefixList.Get(str2), str1)
	AddItemsToList(substringList.Get(str2), str1)
End Sub

Private Sub AddItemsToList(li As List, full As String)
	If li.IsInitialized = False Then Return
	For i = 0 To li.Size - 1
		Dim item As String
		item = li.Get(i)
		If full.Length > MAX_LIMIT And item.ToLowerCase.Contains(full) = False Then
			Continue
		End If
		lv.AddSingleLine(li.Get(i))
	Next
End Sub

'Builds the index and returns an object which you can store as a process global variable
'in order to avoid rebuilding the index when the device orientation changes.
Public Sub SetItems(Items As List) As Object
	Dim startTime As Long
	startTime = DateTime.Now
	ProgressDialogShow2(" ", False)
	Dim noDuplicates As Map
	noDuplicates.Initialize
	prefixList.Clear
	substringList.Clear
	Dim m As Map
	Dim li As List
	For i = 0 To Items.Size - 1
		If i Mod 100 = 0 Then DoEvents
		Dim item As String
		item = Items.Get(i)
		item = item.ToLowerCase
		noDuplicates.Clear
		For start = 0 To item.Length
			Dim count As Int
			count = MIN_LIMIT
			Do While count <= MAX_LIMIT And start + count <= item.Length
				Dim str As String
				str = item.SubString2(start, start + count)
				If noDuplicates.ContainsKey(str) = False Then
					noDuplicates.Put(str, "")
					If start = 0 Then m = prefixList Else m = substringList
					li = m.Get(str)
					If li.IsInitialized = False Then
						li.Initialize
						m.Put(str, li)
					End If
					li.Add(Items.Get(i)) 'Preserve the original case
				End If
				count = count + 1
			Loop
		Next
	Next
	ProgressDialogHide
	Log("Index time: " & (DateTime.Now - startTime) & " ms (" & Items.Size & " Items)")
	Return Array As Object(prefixList, substringList)
End Sub
Public Sub ClearSearchBox
	Dim IME As IME
	et.Text=""
	IME.ShowKeyboard(et)
	
	
	'AddToParent.
	''''''''''''''''''''''''''''''''''''''
	
	
End Sub
'Sets the index from the previously stored index.
Public Sub SetIndex(Index As Object)
	Dim obj() As Object
	obj = Index
	prefixList = obj(0)
	substringList = obj(1)
End Sub