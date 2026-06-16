import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

# Load data files
cdll_df = pd.read_csv('CustomDoublyLinkedList_performance.csv', sep=';')
ll_df = pd.read_csv('LinkedList_performance.csv', sep=';')

# Clean headers
cdll_df.columns = [c.replace('"', '').strip() for c in cdll_df.columns]
ll_df.columns = [c.replace('"', '').strip() for c in ll_df.columns]

sizes = cdll_df['Size'].tolist()
methods = [c for c in cdll_df.columns if c != 'Size']

heatmap_data = np.zeros((len(methods), len(sizes)))
text_labels = []

for i, m in enumerate(methods):
    row_labels = []
    for j, size in enumerate(sizes):
        cdll_val = cdll_df.loc[cdll_df['Size'] == size, m].values[0]
        ll_val = ll_df.loc[ll_df['Size'] == size, m].values[0]

        if cdll_val == 0: cdll_val = 1
        if ll_val == 0: ll_val = 1

        # log2 ratio: positive means Custom is faster (LinkedList took more time)
        ratio = np.log2(ll_val / cdll_val)
        heatmap_data[i, j] = ratio

        if ll_val >= cdll_val:
            factor = ll_val / cdll_val
            row_labels.append(f"+{factor:.1f}x" if factor < 100 else f"+{factor:.0f}x")
        else:
            factor = cdll_val / ll_val
            row_labels.append(f"-{factor:.1f}x" if factor < 100 else f"-{factor:.0f}x")
    text_labels.append(row_labels)

text_labels = np.array(text_labels)

# Sort methods by average performance ratio
avg_ratios = np.mean(heatmap_data, axis=1)
sorted_idx = np.argsort(avg_ratios)

heatmap_data = heatmap_data[sorted_idx]
text_labels = text_labels[sorted_idx]
sorted_methods = [methods[idx] for idx in sorted_idx]

# Plotting the heatmap - with 45 methods, let's use a larger height
fig, ax = plt.subplots(figsize=(18, 22), facecolor='none')
ax.set_facecolor('none')

clipped_data = np.clip(heatmap_data, -4.0, 4.0)
cmap = sns.diverging_palette(15, 240, as_cmap=True)

sns.heatmap(clipped_data,
            annot=text_labels,
            fmt="",
            cmap=cmap,
            center=0,
            xticklabels=sizes,
            yticklabels=sorted_methods,
            ax=ax,
            cbar_kws={
                'label': '← JDK Faster (LinkedList)  |  Relative Speedup Scale (Clipped at 16x)  |  Custom Faster (CustomDoublyLinkedList) →'},
            linewidths=0.5,
            linecolor='#444444',
            annot_kws={'size': 8, 'weight': 'bold'})

ax.set_title(
    'Java LinkedList vs CustomDoublyLinkedList Performance Comparison Matrix Heatmap\n(Positive/Blue = CustomDoublyLinkedList Faster, Negative/Red = LinkedList Faster)',
    color='#ffffff', fontsize=18, fontweight='bold', pad=25)
ax.set_ylabel('List / Deque Interface Methods', color='#aaaaaa', fontsize=14, labelpad=12)
ax.set_xlabel('Collection Size (Elements)', color='#aaaaaa', fontsize=14, labelpad=12)

ax.tick_params(colors='#ffffff', labelsize=11)
plt.xticks(rotation=45)
plt.yticks(rotation=0)

cbar = ax.collections[0].colorbar
cbar.ax.tick_params(colors='#ffffff', labelsize=10)
cbar.ax.yaxis.label.set_color('#ffffff')
cbar.ax.yaxis.label.set_fontsize(13)

plt.tight_layout()
plt.savefig('heatmap.png', dpi=300, transparent=True)
plt.close()

print("Heatmap saved successfully as custom_doubly_linked_list_performance_heatmap.png")
print("Top 5 worst performing methods for Custom on average:")
print(sorted_methods[:5])
print("Top 5 best performing methods for Custom on average:")
print(sorted_methods[-5:])