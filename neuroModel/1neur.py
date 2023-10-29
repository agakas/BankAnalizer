from keras.models import Model
from keras.layers import Dense, Input
from keras.utils import plot_model
import numpy as np
 
dataset = np.loadtxt("D:/table2.csv", delimiter=";")

X = dataset[:,0:35]
num_y = dataset[:,35:46]
classif_y = dataset[:,46]
 
epoh = 100
# Создаём модель!

inp = Input(shape=(35,))
layer1 = Dense(40, activation='relu')(inp)


classifier = Dense(1, activation='sigmoid', name='classifer')(layer1)
regression = Dense(11, activation='linear', name='reg')(layer1)

model = Model(inputs=inp, outputs=[classifier, regression])


model.compile('adam', loss={'classifer':'binary_crossentropy', 'reg':'mse'}, metrics=['accuracy'])

#model.compile(optimizer='adam',
#              loss=['mse','binary_crossentropy'],
#              metrics=['accuracy'])
history = model.fit(X, {'classifer':classif_y, 'reg':num_y}, epochs=epoh, validation_split=0.4)


average_accuracy_class = []
average_accuracy_reg = []
average_loss = []

for i in range(len(history.history["val_classifer_accuracy"])):
    average_accuracy_class.append((history.history["val_classifer_accuracy"][i]+history.history["classifer_accuracy"][i])/2)
    average_accuracy_reg.append((history.history["val_reg_accuracy"][i]+history.history["reg_accuracy"][i])/2)
    average_loss.append((history.history['loss'][i]+history.history['val_loss'][i])/2)


model.save('model.h5')


#визуализация
plot_model(model, to_file='model.png', show_shapes=True)
